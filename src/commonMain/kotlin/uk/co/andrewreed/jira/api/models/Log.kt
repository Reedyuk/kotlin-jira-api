package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Log(
    val self: String,
    val author: Author,
    val updateAuthor: Author,
    val comment: String,
    val updated: String,
    val visibility: Visibility? = null,
    val started: String,
    val timeSpent: String,
    val timeSpentSeconds: Int,
    val id: String,
    val issueId: String
)