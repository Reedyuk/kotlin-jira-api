package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.api.models.Board
import uk.co.andrewreed.jira.api.models.Response

class BoardApi(config: JiraConfig): Client(config) {

    suspend fun boards(): List<Board> = createAuthenticatedRequest(
        Response.serializer(),
        "/rest/agile/1.0/board"
    ).createListValues(Board.serializer())

    //rest/agile/1.0/board/{boardId}
    suspend fun board(boardId: Int): Board = createAuthenticatedRequest(
        Board.serializer(),
        "/rest/agile/1.0/board/$boardId"
    )

}