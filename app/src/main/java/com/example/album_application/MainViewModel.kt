package com.example.album_application


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val userRepository = UserRepository(RetrofitInstance.userApi)
    private val albumRepository = AlbumRepository(RetrofitInstance.albumApi)
    private val photoRepository = PhotoRepository(RetrofitInstance.photoApi)

    val users = MutableLiveData<List<User>>()
    val albums = MutableLiveData<List<Album>>()
    val photos = MutableLiveData<List<Photo>>()
    val error = MutableLiveData<String>()

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                users.value = userRepository.getUsers()
            } catch (e: Exception) {
                error.value = "Failed to load users: ${e.message}"
            }
        }
    }

    fun fetchAlbumsByUser(userId: Int) {
        viewModelScope.launch {
            try {
                albums.value = albumRepository.getAlbumsByUser(userId)
            } catch (e: Exception) {
                error.value = "Failed to load albums: ${e.message}"
            }
        }
    }

    fun fetchPhotosByAlbum(albumId: Int) {
        viewModelScope.launch {
            try {
                photos.value = photoRepository.getPhotosByAlbum(albumId)
            } catch (e: Exception) {
                error.value = "Failed to load photos: ${e.message}"
            }
        }
    }
}
