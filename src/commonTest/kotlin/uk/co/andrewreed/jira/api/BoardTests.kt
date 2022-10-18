package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BoardTests: ClientTest() {

    @Test
    fun fetchBoards() = runTest {
        val boards = client.board.boards()
        println(boards)
        assertTrue(boards.isNotEmpty())
    }

    @Test
    fun fetchBoard() = runTest {
        val boardId = 1
        val board = client.board.board(boardId)
        println(board)
        assertEquals(boardId, board.id)
    }

}