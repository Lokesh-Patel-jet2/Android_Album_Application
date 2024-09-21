package com.example.album_application

import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumApiService {
    @GET("users/{userId}/albums")
    suspend fun getAlbumsByUser(@Path("userId") userId: Int): List<Album>
}
