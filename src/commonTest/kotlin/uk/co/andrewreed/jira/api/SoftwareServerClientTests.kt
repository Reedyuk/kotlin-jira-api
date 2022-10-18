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

    @Test
    fun fetchIssues() = runTest {
        val issues = SoftwareServerClient(config).issues(116)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchEpics() = runTest {
        val epics = SoftwareServerClient(config).epics(116)
        println(epics)
        assertTrue(epics.isNotEmpty())
    }

    @Test
    fun fetchIssueEpics() = runTest {
        val issues = SoftwareServerClient(config).epicIssues(116, 48106)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchIssuesWithoutEpics() = runTest {
        val issues = SoftwareServerClient(config).epicNoneIssues(116)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchProjectForBoard() = runTest {
        val projects = SoftwareServerClient(config).projects(116)
        println(projects)
        assertTrue(projects.isNotEmpty())
    }

    @Test
    fun fetchSprintsForBoard() = runTest {
        val sprints = SoftwareServerClient(config).sprints(71)
        println(sprints)
        assertTrue(sprints.isNotEmpty())
    }

    @Test
    fun fetchIssuesForSprint() = runTest {
        val issues = SoftwareServerClient(config).issuesForSprint(71, 167)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchEpic() = runTest {
        val epicId = 48106
        val epic = SoftwareServerClient(config).epic(epicId)
        println(epic)
        assertEquals(epicId, epic.id)
    }

    @Test
    fun fetchIssue() = runTest {
        val issueId = "49386"
        val issue = SoftwareServerClient(config).issue(issueId)
        println(issue)
        assertEquals(issueId, issue.id)
    }

    @Test
    fun fetchSprint() = runTest {
        val sprintId = 167
        val sprint = SoftwareServerClient(config).sprint(sprintId)
        println(sprint)
        assertEquals(sprintId, sprint.id)
    }
}
