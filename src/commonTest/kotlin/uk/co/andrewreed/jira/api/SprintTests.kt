package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SprintTests: ClientTest() {

    @Test
    fun fetchSprint() = runTest {
        val sprintId = 167
        val sprint = client.sprint.sprint(sprintId)
        println(sprint)
        assertEquals(sprintId, sprint.id)
    }

    @Test
    fun fetchSprintsForBoard() = runTest {
        val sprints = client.sprint.sprints(71)
        println(sprints)
        assertTrue(sprints.isNotEmpty())
    }

}