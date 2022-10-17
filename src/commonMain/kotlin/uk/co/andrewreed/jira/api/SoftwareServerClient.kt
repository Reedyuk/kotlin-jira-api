package uk.co.andrewreed.jira.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import uk.co.andrewreed.jira.api.models.*

class SoftwareServerClient(private val config: JiraConfig) {

    private val url: String = config.serverUrl

    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    private val ktorClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json
        }
        expectSuccess = true
        developmentMode = config.developmentMode
        if (config.showLogging) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

    private fun String.buildUrl(path: String): String = "$this$path"

    private suspend fun <T>createAuthenticatedRequest(
        deserializer: KSerializer<T>,
        path: String,
        requestMethod: HttpMethod = HttpMethod.Get
    ): T = json.decodeFromString(
            deserializer,
            ktorClient.request(url.buildUrl(path)) {
                method = requestMethod
                headers {
                    append(HttpHeaders.Accept, ContentType.Application.Json)
                    append(HttpHeaders.Authorization, config.token)
                }
            }.body() as String
        )

    private fun <T>Response.createListValues(
        deserializer: KSerializer<T>
    ): List<T> = values.map { json.decodeFromJsonElement(deserializer, it) }

    suspend fun boards(): List<Board> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board"
    ).createListValues(Board.serializer())

    //rest/agile/1.0/board/{boardId}
    suspend fun board(boardId: Int): Board = createAuthenticatedRequest(
        Board.serializer(),
        "/rest/agile/1.0/board/$boardId"
    )

    ///rest/agile/1.0/board/{boardId}/backlog
    suspend fun backlog(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/backlog"
    ).issues

    ///rest/agile/1.0/board/{boardId}/issue
    suspend fun issues(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/epic
    suspend fun epics(boardId: Int): List<Epic> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board/$boardId/epic"
    ).createListValues(Epic.serializer())

    ///rest/agile/1.0/board/{boardId}/epic/{epicId}/issue
    suspend fun epicIssues(boardId: Int, epicId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/epic/$epicId/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/epic/none/issue
    suspend fun epicNoneIssues(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/epic/none/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/project
    suspend fun projects(boardId: Int): List<Project> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board/$boardId/project"
    ).createListValues(Project.serializer())

    ///rest/agile/1.0/board/{boardId}/sprint
    suspend fun sprints(boardId: Int): List<Sprint> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board/$boardId/sprint"
    ).createListValues(Sprint.serializer())
}
