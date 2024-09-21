package com.example.album_application

import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoApiService {
    @GET("albums/{albumId}/photos")
    suspend fun getPhotosByAlbum(@Path("albumId") albumId: Int): List<Photo>
}
