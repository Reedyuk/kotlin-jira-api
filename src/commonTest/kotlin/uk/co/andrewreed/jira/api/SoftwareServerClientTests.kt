package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SoftwareServerClientTests {

    val config = JiraConfig(

    )

    @Test
    fun fetchBoards() = runTest {
        val boards = SoftwareServerClient(config).boards()
        println(boards)
        assertTrue(boards.isNotEmpty())
    }

    @Test
    fun fetchBoard() = runTest {
        val boardId = 1
        val board = SoftwareServerClient(config).board(boardId)
        println(board)
        assertEquals(boardId, board.id)
    }

    @Test
    fun fetchIssuesForBacklog() = runTest {
        val issues = SoftwareServerClient(config).backlog(116)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }
}
