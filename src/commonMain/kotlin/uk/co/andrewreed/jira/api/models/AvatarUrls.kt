package uk.co.andrewreed.jira.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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