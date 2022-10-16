package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Fields(
    val flagged: Boolean,
    val sprint: Sprint?,
    val closedSprints: List<ClosedSprint> = emptyList(),
    val description: String?,
    val project: Project,
    val comment: Comments,
    val epic: Epic? = null,
    val worklog: Logs,
    val updated: String,
    val timetracking: TimeTracking
)