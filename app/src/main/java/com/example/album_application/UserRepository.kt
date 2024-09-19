package com.example.album_application

class UserRepository(private val apiService: UserApiService) {
    suspend fun getUsers() = apiService.getUsers()
    suspend fun getAlbumsByUser(userId: Int) = apiService.getAlbumsByUser(userId)
    suspend fun getPhotosByAlbum(albumId: Int) = apiService.getPhotosByAlbum(albumId)
}