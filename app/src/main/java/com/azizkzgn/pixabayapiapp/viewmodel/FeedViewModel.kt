package com.azizkzgn.pixabayapiapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azizkzgn.pixabayapiapp.model.Photo
import com.azizkzgn.pixabayapiapp.service.PhotoApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel: ViewModel() {
    private val photoApiService = PhotoApiService()
    private val disposable = CompositeDisposable()
    val datas = MutableLiveData<Photo>()


    fun refreshData(){
        getDataFromApi()
    }

    private fun getDataFromApi(){
        disposable.add(
            photoApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<Photo>(){
                    override fun onSuccess(t: Photo) {
                        datas.value = t
                    }

                    override fun onError(e: Throwable) {

                    }

                })

        )

    }
}