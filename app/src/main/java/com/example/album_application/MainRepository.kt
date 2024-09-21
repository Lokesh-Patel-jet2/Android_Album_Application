package com.example.album_application

class MainRepository(private val userApiService: UserApiService,
                     private val albumRepository: AlbumRepository,
                     private val photoRepository: PhotoRepository) {

    suspend fun getUsers() = userApiService.getUsers()
    suspend fun getAlbumsByUser(userId: Int) = albumRepository.getAlbumsByUser(userId)
    suspend fun getPhotosByAlbum(albumId: Int) = photoRepository.getPhotosByAlbum(albumId)
}
