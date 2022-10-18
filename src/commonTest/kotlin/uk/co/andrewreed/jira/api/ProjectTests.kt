package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class ProjectTests: ClientTest() {
    @Test
    fun fetchProjectForBoard() = runTest {
        val projects = client.project.projects(116)
        println(projects)
        assertTrue(projects.isNotEmpty())
    }
}