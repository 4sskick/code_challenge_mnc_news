package id.niteroomcreation.mncnews.data.repository

import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.data.data_source.remote.NewsApi
import id.niteroomcreation.mncnews.domain.mapper.toArticle
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.domain.repository.NewsRepository
import okio.IOException
import javax.inject.Inject

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {
    override suspend fun getArticles(): Resource<List<Article>> = try {
        val response = api.getArticles()
        response.let { resp ->
            if (resp.isSuccessful) {
                val articleResponse = resp.body() ?: emptyList()
                Resource.Success(articleResponse.map { it.toArticle() })
            } else {
                Resource.Error(response.errorBody()!!.string(), IOException(response.message()))
            }
        }
    } catch (e: Exception) {
        Resource.Error("An error happen", IOException(e))
    }
}