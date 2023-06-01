package com.example.myapplication


import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {

    @Headers("authorization: apikey 3ahY7HGn5OMO2rqSVonCxU:59JZgntsjO1lKPTjTqvZjS")
    @GET("/book/newBook")
    suspend fun fetchPost(): MyPost
}

data class MyPost(
    val succes: String,
    val result: List<result>
)
data class result(
    val url: String,
    val fiyat: String,
    val yayın: String,
    val yazar: String,
    val title: String,
    val image: String
)