package com.example.album_application

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Display users
        val userAdapter = UserAdapter { user ->
            viewModel.fetchAlbumsByUser(user.id)
        }
        recyclerView.adapter = userAdapter

        viewModel.users.observe(this) { users ->
            userAdapter.submitList(users)
        }

        // Fetch users initially
        viewModel.fetchUsers()

        // Handle albums
        val albumAdapter = AlbumAdapter { album ->
            viewModel.fetchPhotosByAlbum(album.id)
        }

        viewModel.albums.observe(this) { albums ->
            recyclerView.adapter = albumAdapter
            albumAdapter.submitList(albums)
        }

        // Handle photos
        val photoAdapter = PhotoAdapter()
        viewModel.photos.observe(this) { photos ->
            recyclerView.adapter = photoAdapter
            photoAdapter.submitList(photos)
        }
    }
}
