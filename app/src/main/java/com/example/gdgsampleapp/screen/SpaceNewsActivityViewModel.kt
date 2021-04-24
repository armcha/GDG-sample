package com.example.gdgsampleapp.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gdgsampleapp.api.Api
import com.example.gdgsampleapp.model.SpaceNews
import com.example.gdgsampleapp.model.ViewState
import com.example.gdgsampleapp.repository.RepositoryProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpaceNewsActivityViewModel : ViewModel() {

    private val spaceNewsRepository = RepositoryProvider.spaceNewsRepository

    val articlesLiveData = MutableLiveData<List<SpaceNews>>()
    val viewState = MutableLiveData<ViewState>(ViewState.Loading)

    init {
        viewModelScope.launch {
            viewState.postValue(ViewState.Loading)
            try {
                val articles = spaceNewsRepository.getArticles()
                articlesLiveData.postValue(articles)
            } catch (exception: Exception) {
                viewState.postValue(ViewState.Error(exception.message))
            }
            viewState.postValue(ViewState.Complete)
        }
    }
}