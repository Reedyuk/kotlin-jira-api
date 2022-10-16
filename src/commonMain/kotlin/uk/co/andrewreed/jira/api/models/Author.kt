package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val self: String,
    val accountId: String,
    val displayName: String,
    val active: Boolean
)