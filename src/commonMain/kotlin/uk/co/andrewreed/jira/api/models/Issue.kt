package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Issue(
    val id: String,
    val self: String,
    val key: String,
    val fields: Fields
)

@Serializable
data class Fields(
    val flagged: Boolean,
    val sprint: Sprint?,
    val closedSprints: List<ClosedSprint> = emptyList(),
    val description: String?,
    val project: Project,
    val comment: Comments,
    val epic: Epic? = null,
    val worklog: Logs,
    val updated: String,
    val timetracking: TimeTracking
)

@Serializable
data class Sprint(
    val id: Int,
    val self: String,
    val state: String,
    val name: String
)

@Serializable
data class ClosedSprint(
    val id: Int,
    val self: String,
    val state: String,
    val name: String,
    val startDate: String,
    val endDate: String,
    val completeDate: String
)

@Serializable
data class Project(
    val id: String,
    val self: String,
    val key: String,
    val name: String,
    val avatarUrls: AvatarUrls,
    val projectCategory: ProjectCategory? = null
)

@Serializable
data class AvatarUrls(
    @SerialName("48x48")
    val fourtyEight: String,
    @SerialName("24x24")
    val twentyFour: String,
    @SerialName("16x16")
    val sixteen: String,
    @SerialName("32x32")
    val thirtyTwo: String,
)

@Serializable
data class ProjectCategory(
    val id: String,
    val self: String,
    val name: String,
    val description: String
)

@Serializable
data class Comments(
    val comments: List<Comment>
)

@Serializable
data class Comment(
    val id: String,
    val self: String,
    val author: Author,
    val body: String,
    val updateAuthor: Author,
    val created: String,
    val updated: String,
    val visibility: Visibility? = null
)

@Serializable
data class Author(
    val self: String,
    val accountId: String,
    val displayName: String,
    val active: Boolean
)

@Serializable
data class Visibility(
    val type: String,
    val value: String
)

@Serializable
data class Epic(
    val id: Int,
    val self: String,
    val name: String,
    val summary: String,
    val color: Color,
    val done: Boolean
)

@Serializable
data class Color(
    val key: String
)

@Serializable
data class Logs(
    val startAt: Int,
    val maxResults: Int,
    val total: Int,
    val worklogs: List<Log>
)

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

@Serializable
data class TimeTracking(
    val originalEstimate: String? = null,
    val remainingEstimate: String? = null,
    val timeSpent: String? = null,
    val originalEstimateSeconds: Int? = null,
    val remainingEstimateSeconds: Int? = null,
    val timeSpentSeconds: Int? = null
)