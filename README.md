# Kotlin-Jira-API

A Kotlin Multiplatform implementation of the Jira API

## Running

The library works on the following platforms: Android, iOS, JavaScript, JVM.

## Installation

## Usage

### Basic Authentication

When accessing the Jira api using basic authentication, you will need to set the following

```aidl
    JiraConfig(
        username = "jiraUsernameEmail",
        password = "jiraPassword",
        host = "PROJECTName.atlassian.net"
    )
```

### OAuth

When accessing the Jira api using OAuth, you will need to set the following

```aidl
    JiraConfig(
        accessToken = "ACCESSTokenFromOAuth",
        host = "api.atlassian.com/ex/jira/CLOUDID"
    )
```

If you follow this guide: https://developer.atlassian.com/cloud/jira/platform/oauth-2-3lo-apps/

Then you will get an access token and a jira cloudId, you will need to set those in the jira config.
