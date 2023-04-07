package id.niteroomcreation.mncnews.presentation.home

import id.niteroomcreation.mncnews.domain.model.Article

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
data class HomeState(
    var isLoading: Boolean = true,
    var articleList: List<Article> = emptyList(),
)