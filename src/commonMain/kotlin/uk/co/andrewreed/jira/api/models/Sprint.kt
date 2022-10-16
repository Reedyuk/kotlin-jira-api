package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Sprint(
    val id: Int,
    val self: String,
    val state: String,
    val name: String
)