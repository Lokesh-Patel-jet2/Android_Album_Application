package com.example.album_application

import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{userId}/albums")
    suspend fun getAlbumsByUser(@Path("userId") userId: Int): List<Album>

    @GET("albums/{albumId}/photos")
    suspend fun getPhotosByAlbum(@Path("albumId") albumId: Int): List<Photo>
}
