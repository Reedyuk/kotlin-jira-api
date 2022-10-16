package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class ProjectCategory(
    val id: String,
    val self: String,
    val name: String,
    val description: String
)