package com.example.album_application

class UserRepository(private val apiService: UserApiService) {
    suspend fun getUsers() = apiService.getUsers()
}


