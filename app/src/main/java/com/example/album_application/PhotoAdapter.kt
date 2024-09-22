package com.example.album_application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter(private val onPhotoClick: (Photo) -> Unit) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    private var photoList: List<Photo> = emptyList()

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoImageView: ImageView = itemView.findViewById(R.id.photoImageView)
        val photoTitleTextView: TextView = itemView.findViewById(R.id.photoTitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photoList[position]
        holder.photoTitleTextView.text = photo.title
        Glide.with(holder.itemView.context)
            .load("https://picsum.photos/200/300")
            .into(holder.photoImageView)

        holder.itemView.setOnClickListener { onPhotoClick(photo) }
    }

    override fun getItemCount(): Int = photoList.size

    fun submitList(list: List<Photo>) {
        photoList = list
        notifyDataSetChanged()
    }
}
