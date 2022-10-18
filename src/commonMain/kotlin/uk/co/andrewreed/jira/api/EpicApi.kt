package uk.co.andrewreed.jira.api

import io.ktor.http.*
import kotlinx.serialization.builtins.serializer
import uk.co.andrewreed.jira.api.models.Epic
import uk.co.andrewreed.jira.api.models.Response

class EpicApi(config: JiraConfig): Client(config) {

    ///rest/agile/1.0/epic/{epicIdOrKey}
    suspend fun epic(epicIdOrKey: Int): Epic = createAuthenticatedRequest(
        Epic.serializer(),
        "/rest/agile/1.0/epic/$epicIdOrKey"
    )

    ///rest/agile/1.0/board/{boardId}/epic
    suspend fun epics(boardId: Int): List<Epic> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board/$boardId/epic"
    ).createListValues(Epic.serializer())

    suspend fun deleteEpic(epicIdOrKey: Int) = createAuthenticatedRequest(
        Unit.serializer(),
        "/rest/api/2/issue/$epicIdOrKey",
        HttpMethod.Delete
    )
}