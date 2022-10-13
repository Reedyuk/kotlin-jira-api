package uk.co.andrewreed.jira.api

import io.ktor.util.*

data class JiraConfig(
    val username: String? = null,
    val password: String? = null,
    val accessToken: String? = null,
    val secureHost: Boolean = true,
    val host: String,
    val port: String? = null
) {
    val token: String = accessToken?.let { "Bearer $it" } ?:
        "Basic ${("${username!!}:${password!!}".encodeBase64())}"
    val serverUrl: String =
        "${"https".takeIf { secureHost } ?: "http"}://$host${port?.let { ":$it" } ?: ""}"
}
