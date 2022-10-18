package uk.co.andrewreed.jira.api

abstract class ClientTest {

    val config = JiraConfig(
    )

    protected val client = JiraClient(config)
}