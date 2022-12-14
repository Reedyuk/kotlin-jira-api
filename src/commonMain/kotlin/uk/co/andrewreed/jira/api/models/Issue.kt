package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Issue(
    val id: String,
    val self: String,
    val key: String,
    val fields: Fields
)
