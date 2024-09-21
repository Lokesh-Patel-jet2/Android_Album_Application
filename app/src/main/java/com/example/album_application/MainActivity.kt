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

        val userAdapter = UserAdapter { user ->
            viewModel.fetchAlbumsByUser(user.id)
        }
        recyclerView.adapter = userAdapter

        viewModel.users.observe(this) { users ->
            userAdapter.submitList(users)
        }

        viewModel.albums.observe(this) { albums ->
            // Handle displaying albums, you can create a new RecyclerView or update the existing one
            val albumAdapter = AlbumAdapter { album ->
                viewModel.fetchPhotosByAlbum(album.id)
            }
            recyclerView.adapter = albumAdapter
            albumAdapter.submitList(albums)
        }

        viewModel.photos.observe(this) { photos ->
            // Handle displaying photos, you can create a new RecyclerView or update the existing one
            val photoAdapter = PhotoAdapter { photo ->
                // Handle photo click if needed
            }
            recyclerView.adapter = photoAdapter
            photoAdapter.submitList(photos)
        }

        // Fetch users initially
        viewModel.fetchUsers()
    }
}
