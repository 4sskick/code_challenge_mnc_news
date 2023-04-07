package id.niteroomcreation.mncnews.domain.repository

import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.domain.model.Article

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
interface NewsRepository {
    suspend fun getArticles(): Resource<List<Article>>
}