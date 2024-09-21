package com.example.album_application

class PhotoRepository(private val apiService: PhotoApiService) {
    suspend fun getPhotosByAlbum(albumId: Int) = apiService.getPhotosByAlbum(albumId)
}

