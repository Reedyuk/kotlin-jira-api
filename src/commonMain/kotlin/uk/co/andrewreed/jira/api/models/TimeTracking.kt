package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class TimeTracking(
    val originalEstimate: String? = null,
    val remainingEstimate: String? = null,
    val timeSpent: String? = null,
    val originalEstimateSeconds: Int? = null,
    val remainingEstimateSeconds: Int? = null,
    val timeSpentSeconds: Int? = null
)