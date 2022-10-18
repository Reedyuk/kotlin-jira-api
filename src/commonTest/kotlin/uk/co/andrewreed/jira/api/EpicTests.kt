package uk.co.andrewreed.jira.api

import uk.co.andrewreed.jira.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EpicTests: ClientTest() {

    @Test
    fun fetchEpic() = runTest {
        val epicId = 48106
        val epic = client.epic.epic(epicId)
        println(epic)
        assertEquals(epicId, epic.id)
    }

    @Test
    fun fetchEpics() = runTest {
        val epics = client.epic.epics(116)
        println(epics)
        assertTrue(epics.isNotEmpty())
    }


}