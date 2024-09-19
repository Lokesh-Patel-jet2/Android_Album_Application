package com.example.album_application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(private val onAlbumClick: (Album) -> Unit) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var albumList: List<Album> = emptyList()

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumTitleTextView: TextView = itemView.findViewById(R.id.albumTitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.albumTitleTextView.text = album.title
        holder.itemView.setOnClickListener { onAlbumClick(album) }
    }

    override fun getItemCount(): Int = albumList.size

    fun submitList(list: List<Album>) {
        albumList = list
        notifyDataSetChanged()
    }
}
