package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.api.models.Issue
import uk.co.andrewreed.jira.api.models.ResponseIssues

class IssueApi(config: JiraConfig): Client(config) {

    ///rest/agile/1.0/issue/{issueIdOrKey}
    suspend fun issue(issueIdOrKey: String): Issue = createAuthenticatedRequest(
        Issue.serializer(),
        "/rest/agile/1.0/issue/$issueIdOrKey"
    )

    ///rest/agile/1.0/board/{boardId}/sprint/{sprintId}/issue
    suspend fun issuesForSprint(boardId: Int, sprintId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/sprint/$sprintId/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/epic/none/issue
    suspend fun epicNoneIssues(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/epic/none/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/epic/{epicId}/issue
    suspend fun epicIssues(boardId: Int, epicId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/epic/$epicId/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/issue
    suspend fun issues(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/issue"
    ).issues

    ///rest/agile/1.0/board/{boardId}/backlog
    suspend fun backlog(boardId: Int): List<Issue> = createAuthenticatedRequest(
        ResponseIssues.serializer(),
        "/rest/agile/1.0/board/$boardId/backlog"
    ).issues
}