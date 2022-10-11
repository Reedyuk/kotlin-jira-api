package uk.co.andrewreed.jira.api

data class JiraConfig(
    val username: String,
    val password: String,
    val secureHost: Boolean = true,
    val host: String,
    val port: String? = null
) {
    val serverUrl: String =
        "${"https".takeIf { secureHost } ?: "http"}://$host${port?.let { ":$it" } ?: ""}"
}
