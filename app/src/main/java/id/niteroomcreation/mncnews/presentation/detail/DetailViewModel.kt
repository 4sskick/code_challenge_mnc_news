package id.niteroomcreation.mncnews.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.presentation.home.hot.HotNewsFragment
import id.niteroomcreation.mncnews.util.LogHelper
import javax.inject.Inject

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        val TAG = DetailViewModel::class.java.simpleName
    }

    private val article: Article? = savedStateHandle.get<Article>(HotNewsFragment.ARTICLE_DATA)
    private val state_ = MutableLiveData<Resource<DetailState>>();
    val state: LiveData<Resource<DetailState>> get() = state_


    init {
        state_.value = Resource.Loading
        LogHelper.e(TAG, "article data $article")

        article?.let {
            state_.value = Resource.Success(DetailState(article = it))
        }
    }
}