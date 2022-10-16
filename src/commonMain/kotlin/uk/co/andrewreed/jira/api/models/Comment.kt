package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: String,
    val self: String,
    val author: Author,
    val body: String,
    val updateAuthor: Author,
    val created: String,
    val updated: String,
    val visibility: Visibility? = null
)