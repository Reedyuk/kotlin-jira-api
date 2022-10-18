package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IssueTests: ClientTest() {

    @Test
    fun fetchIssue() = runTest {
        val issueId = "49386"
        val issue = client.issue.issue(issueId)
        println(issue)
        assertEquals(issueId, issue.id)
    }

    @Test
    fun fetchIssuesForSprint() = runTest {
        val issues = client.issue.issuesForSprint(71, 167)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchIssuesForBacklog() = runTest {
        val issues = client.issue.backlog(116)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchIssues() = runTest {
        val issues = client.issue.issues(116)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchIssueEpics() = runTest {
        val issues = client.issue.epicIssues(116, 48106)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }

    @Test
    fun fetchIssuesWithoutEpics() = runTest {
        val issues = client.issue.epicNoneIssues(116)
        println(issues)
        assertTrue(issues.isNotEmpty())
    }
}