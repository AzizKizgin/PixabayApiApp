package com.azizkzgn.pixabayapiapp.service

import com.azizkzgn.pixabayapiapp.model.Photo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotoApiService {

    private val BASE_URL="https://pixabay.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(PhotoApi::class.java)

    fun getData():Single<Photo>{
        return api.getData()
    }
}