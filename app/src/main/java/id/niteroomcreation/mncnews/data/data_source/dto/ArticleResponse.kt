package id.niteroomcreation.mncnews.data.data_source.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
data class ArticleResponse(

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("contributorAvatar")
    val contributorAvatar: String? = null,

    @field:SerializedName("contentThumbnail")
    val contentThumbnail: String? = null,

    @field:SerializedName("slideshow")
    val slideshow: List<String>? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("contributorName")
    val contributorName: String? = null,

    @field:SerializedName("content")
    val content: String? = null
)
