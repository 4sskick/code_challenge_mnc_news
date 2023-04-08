package id.niteroomcreation.mncnews.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.niteroomcreation.mncnews.data.common.Dispatcher
import id.niteroomcreation.mncnews.data.common.Resource
import id.niteroomcreation.mncnews.domain.model.Article
import id.niteroomcreation.mncnews.domain.repository.NewsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Septian Adi Wijaya on 07/04/2023.
 * please be sure to add credential if you use people's code
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val state_ = MutableLiveData<Resource<List<Article>>>();
    val state: LiveData<Resource<List<Article>>> get() = state_


    init {
        doGetArticles();
    }

    fun doGetArticles() {
        state_.value = Resource.Loading
        viewModelScope.launch {
            val result = repository.getArticles()
            state_.postValue(result)
        }
    }
}