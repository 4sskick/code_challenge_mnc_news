package id.niteroomcreation.mncnews.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.data.repository.NewsRepositoryImpl
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.util.MainCoroutineRule
import id.niteroomcreation.mncnews.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException

/**
 * Created by Septian Adi Wijaya on 08/04/2023.
 * please be sure to add credential if you use people's code
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @Mock
    private lateinit var repo: NewsRepositoryImpl
    private lateinit var homeViewModel: HomeViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcher = MainCoroutineRule()

    @Before
    fun setup() {
        homeViewModel = HomeViewModel(repository = repo)
    }

    @Test
    fun `doGetArticles() not null and return success`() = runTest {
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

        `when`(repo.getArticles()).thenReturn(expect)
        homeViewModel.doGetArticles()

        val actual = homeViewModel.state.getOrAwaitValue()

        //set 2 times because it declared on init homeviewmodel
        Mockito.verify(repo, times(2)).getArticles()

        Assert.assertNotNull(actual)
        Assert.assertEquals(expect, actual)
        Assert.assertTrue(actual is Resource.Success)
    }

    @Test
    fun `doGetArticles() not null and return error`() = runTest {
        val expect = Resource.Error(message = "fake error message", exception = IOException())

        `when`(repo.getArticles()).thenReturn(expect)
        homeViewModel.doGetArticles()

        val actual = homeViewModel.state.getOrAwaitValue()

        //set 2 times because it declared on init homeviewmodel
        Mockito.verify(repo, times(2)).getArticles()

        Assert.assertNotNull(actual)
        Assert.assertEquals(expect, actual)
        Assert.assertTrue(actual is Resource.Error)
    }
}