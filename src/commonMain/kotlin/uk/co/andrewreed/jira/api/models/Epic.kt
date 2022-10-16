package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Epic(
    val id: Int,
    val self: String,
    val name: String,
    val summary: String,
    val color: Color,
    val done: Boolean
)