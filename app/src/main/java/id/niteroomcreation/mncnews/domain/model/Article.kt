package id.niteroomcreation.mncnews.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
@Parcelize
data class Article(
    val createdAt: String,
    val contributorAvatar: String,
    val contentThumbnail: String,
    val slideshow: List<String>,
    val id: String,
    val title: String,
    val contributorName: String,
    val content: String
) : Parcelable