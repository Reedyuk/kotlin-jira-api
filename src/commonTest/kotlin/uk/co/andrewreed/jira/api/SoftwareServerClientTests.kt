package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SoftwareServerClientTests {

    val config = JiraConfig(
        username = "",
        password = "",
        host = ""
    )

    @Test
    fun fetchBoards() = runTest {
        val boards = SoftwareServerClient(config).boards()
        println(boards)
        assertTrue(boards.isNotEmpty())
    }

    @Test
    fun fetchBoard() = runTest {
        val board = SoftwareServerClient(config).board(1)
        println(board)
        assertEquals(1, board.id)
    }
}
