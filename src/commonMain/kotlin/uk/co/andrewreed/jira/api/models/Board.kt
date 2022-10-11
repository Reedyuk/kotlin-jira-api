package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Board(
    val id: Int,
    val self: String,
    val name: String,
    val type: String
)
