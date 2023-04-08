package id.niteroomcreation.mncnews.data.repository

import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.data.data_source.dto.ArticleResponse
import id.niteroomcreation.mncnews.data.data_source.remote.NewsApi
import id.niteroomcreation.mncnews.domain.model.Article
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response
import java.io.IOException

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
class NewsRepositoryImplTes {

    @Mock
    lateinit var api: NewsApi

    private lateinit var repository: NewsRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = NewsRepositoryImpl(api = api)
    }

    @Test
    fun `repo not null and return success`() = runBlocking {
        val expect = Resource.Success(
            listOf(
                Article(
                    id = "FAKE_ID_1",
                    title = "FAKE_TITLE",
                    contributorName = "FAKE_CONTRIBUTOR_NAME",
                    content = "FAKE_CONTENT",
                    createdAt = "FAKE_CREATE_AT",
                    contributorAvatar = "FAKE_CONTRIBUTOR_AVATAR",
                    contentThumbnail = "FAKE_CONTENT_THUMBNAIL",
                    slideshow = listOf("FAKE_SLIDESHOW_1", "FAKE_SLIDESHOW_2", "FAKE_SLIDESHOW_3")
                )
            )
        )

        val remoteResponse = listOf(
            ArticleResponse(
                id = "FAKE_ID_1",
                title = "FAKE_TITLE",
                contributorName = "FAKE_CONTRIBUTOR_NAME",
                content = "FAKE_CONTENT",
                createdAt = "FAKE_CREATE_AT",
                contributorAvatar = "FAKE_CONTRIBUTOR_AVATAR",
                contentThumbnail = "FAKE_CONTENT_THUMBNAIL",
                slideshow = listOf("FAKE_SLIDESHOW_1", "FAKE_SLIDESHOW_2", "FAKE_SLIDESHOW_3")
            )
        )

        `when`(api.getArticles()).thenReturn(Response.success(remoteResponse))

        val actual: Resource<List<Article>> = repository.getArticles()
        Mockito.verify(api).getArticles()

        Assert.assertNotNull(actual)
        Assert.assertEquals(expect, actual)
        Assert.assertTrue(actual is Resource.Success)
    }

//    @Test
//    fun `repo not null and return error`() = runBlocking {
//        val expect = Resource.Error(message = "fake error body response", exception = IOException())
//
//        //set return value to what we already set
////        `when`(api.getArticles()).thenReturn(Response.error(400, "".toResponseBody(contentType = null)))
//        `when`(api.getArticles()).thenReturn(Response.error(400, "".toResponseBody(contentType = null)))
//
//        val actual = repository.getArticles()
//        Mockito.verify(api).getArticles()
//
//        Assert.assertNotNull(actual)
//        Assert.assertEquals(expect, actual)
//        Assert.assertTrue(actual is Resource.Error)
//    }
}