package uk.co.andrewreed.jira.api

class JiraClient(config: JiraConfig) {
    val sprint = SprintApi(config)
    val issue = IssueApi(config)
    val epic = EpicApi(config)
    val board = BoardApi(config)
    val project = ProjectApi(config)
}