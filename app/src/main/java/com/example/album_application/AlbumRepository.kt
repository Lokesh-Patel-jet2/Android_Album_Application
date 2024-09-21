package com.example.album_application

class AlbumRepository(private val apiService: AlbumApiService) {
    suspend fun getAlbumsByUser(userId: Int) = apiService.getAlbumsByUser(userId)
}

