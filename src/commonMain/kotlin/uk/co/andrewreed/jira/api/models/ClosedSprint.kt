package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ClosedSprint(
    val id: Int,
    val self: String,
    val state: String,
    val name: String,
    val startDate: String,
    val endDate: String,
    val completeDate: String
)