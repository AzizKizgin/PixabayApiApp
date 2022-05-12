package com.azizkzgn.pixabayapiapp.service

import com.azizkzgn.pixabayapiapp.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotoApi {

    //https://pixabay.com/api/?key=18373214-fc1713cf12dfcf884daa59445&per_page=25&image_type=%22photo%22&orientation=%22horizontal%22&order=%22popular%22

    @GET("api/?key=18373214-fc1713cf12dfcf884daa59445&per_page=25&image_type=%22photo%22&orientation=%22horizontal%22&order=%22popular%22")
    fun getData():Single<Photo>
}