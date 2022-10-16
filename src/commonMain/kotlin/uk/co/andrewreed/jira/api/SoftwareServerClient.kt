package uk.co.andrewreed.jira.api

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import uk.co.andrewreed.jira.api.models.Board
import uk.co.andrewreed.jira.api.models.Issue
import uk.co.andrewreed.jira.api.models.Response
import uk.co.andrewreed.jira.api.models.ResponseIssues

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

    private suspend fun <T>createAuthenticatedRequestList(
        deserializer: KSerializer<T>,
        path: String,
        requestMethod: HttpMethod = HttpMethod.Get
    ): List<T> = createAuthenticatedRequest(Response.serializer(), path, requestMethod)
        .createListValues(deserializer)

    private fun <T>Response.createListValues(
        deserializer: KSerializer<T>
    ): List<T> = values.map { json.decodeFromJsonElement(deserializer, it) }

    suspend fun boards(): List<Board> = createAuthenticatedRequestList(
        Board.serializer(),
        "/rest/agile/1.0/board"
    )

    //rest/agile/1.0/board/{boardId}
    suspend fun board(boardId: Int): Board = createAuthenticatedRequest(
        Board.serializer(),
        "/rest/agile/1.0/board/$boardId"
    )

    ///rest/agile/1.0/board/{boardId}/backlog
    suspend fun issues(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/backlog"
    ).issues

}
