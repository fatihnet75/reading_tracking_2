package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _post = MutableLiveData<MyPost>()
    val post: LiveData<MyPost>
        get() = _post

    init {
        fetchPost()
    }

    private fun fetchPost() {
        viewModelScope.launch {
            val myPost: MyPost = RetrofitInstance.api.fetchPost()
            _post.value = myPost

        }
    }
}
