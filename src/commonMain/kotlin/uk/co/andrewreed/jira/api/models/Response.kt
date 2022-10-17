package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray

@Serializable
data class Response(
    val startAt: Int,
    val maxResults: Int,
    val total: Int? = null,
    val values: JsonArray
)

@Serializable
data class ResponseIssues(
    val startAt: Int,
    val maxResults: Int,
    val total: Int,
    val issues: List<Issue>
)

