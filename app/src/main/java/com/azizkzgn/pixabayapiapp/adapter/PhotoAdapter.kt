package com.azizkzgn.pixabayapiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azizkzgn.pixabayapiapp.R
import com.azizkzgn.pixabayapiapp.model.Photo
import com.azizkzgn.pixabayapiapp.util.downloadFromUrl
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(val photoList:ArrayList<Photo.Hit>):RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_photo,parent,false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.itemView.photoId.downloadFromUrl(photoList[position].largeImageURL.toString())
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    fun updateList(newList: List<Photo.Hit>){
        photoList.clear()
        photoList.addAll(newList)
        notifyDataSetChanged()
    }
}