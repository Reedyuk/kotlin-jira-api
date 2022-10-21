# Kotlin-Jira-API

A Kotlin Multiplatform implementation of the Jira API

https://docs.atlassian.com/jira-software/REST/7.3.1/#agile/1.0/board-getAllBoards

## Running

The library works on the following platforms: Android, iOS, JavaScript, JVM.

## Installation

## Usage

### Basic Authentication

When accessing the Jira api using basic authentication, you will need to set the following

```kotlin
    JiraConfig(
        username = "jiraUsernameEmail",
        password = "jiraPassword",
        host = "PROJECTName.atlassian.net"
    )
```

### OAuth

When accessing the Jira api using OAuth, you will need to set the following

```kotlin
    JiraConfig(
        accessToken = "ACCESSTokenFromOAuth",
        host = "api.atlassian.com/ex/jira/CLOUDID"
    )
```

If you follow this guide: https://developer.atlassian.com/cloud/jira/platform/oauth-2-3lo-apps/

Then you will get an access token and a jira cloudId, you will need to set those in the jira config.

### Client

Once you have a JiraConfig object, then you need to create the client

```kotlin
val client = JiraClient(config)
```

Then you can call the relevant endpoints.

```kotlin
client.sprint.sprint(1)
client.board.board(1)
client.issue.issue(1)
client.epic.epic(1)
client.project.projects(1)
```

Each service can be accessed from the client and then you can perform the relevant request, e.g. .issue.issues()
