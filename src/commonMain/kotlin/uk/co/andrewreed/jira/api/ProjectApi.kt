package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.api.models.Project
import uk.co.andrewreed.jira.api.models.Response

class ProjectApi(config: JiraConfig): Client(config) {

    ///rest/agile/1.0/board/{boardId}/project
    suspend fun projects(boardId: Int): List<Project> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board/$boardId/project"
    ).createListValues(Project.serializer())

}