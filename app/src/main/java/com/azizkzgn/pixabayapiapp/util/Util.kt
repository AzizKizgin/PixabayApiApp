package com.azizkzgn.pixabayapiapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.downloadFromUrl(url:String){
    Glide.with(context)
        .load(url)
        .into(this)

}