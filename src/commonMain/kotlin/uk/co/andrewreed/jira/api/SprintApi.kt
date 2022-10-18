package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.api.models.Response
import uk.co.andrewreed.jira.api.models.Sprint

class SprintApi(config: JiraConfig): Client(config) {

    ///rest/agile/1.0/sprint/{sprintId}
    suspend fun sprint(sprintId: Int): Sprint = createAuthenticatedRequest(
        Sprint.serializer(),
        "/rest/agile/1.0/sprint/$sprintId"
    )

    ///rest/agile/1.0/board/{boardId}/sprint
    suspend fun sprints(boardId: Int): List<Sprint> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board/$boardId/sprint"
    ).createListValues(Sprint.serializer())

}