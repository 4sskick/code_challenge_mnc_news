package id.niteroomcreation.mncnews.domain.mapper

import id.niteroomcreation.mncnews.data.data_source.dto.ArticleResponse
import id.niteroomcreation.mncnews.domain.model.Article

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
fun ArticleResponse.toArticle(): Article {
    return Article(
        id = id ?: "",
        title = title ?: "",
        contributorName = contributorName ?: "",
        content = content ?: "",
        createdAt = createdAt ?: "",
        contributorAvatar = contributorAvatar ?: "",
        contentThumbnail = contentThumbnail ?: "",
        slideshow = slideshow ?: emptyList()
    )
}