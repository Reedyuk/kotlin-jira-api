package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.Serializable

@Serializable
data class Project(
    val id: String,
    val self: String,
    val key: String,
    val name: String,
    val avatarUrls: AvatarUrls,
    val projectCategory: ProjectCategory? = null
)