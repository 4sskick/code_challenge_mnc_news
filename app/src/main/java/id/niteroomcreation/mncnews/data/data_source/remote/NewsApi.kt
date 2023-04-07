package id.niteroomcreation.mncnews.data.data_source.remote

import id.niteroomcreation.mncnews.data.data_source.dto.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */
interface NewsApi {
    @GET("api/innocent/newsapp/articles")
    suspend fun getArticles(): Response<List<ArticleResponse>>
}