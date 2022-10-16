package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Logs(
    val startAt: Int,
    val maxResults: Int,
    val total: Int,
    val worklogs: List<Log>
)