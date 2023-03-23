package com.example.rxjava2lesson35

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ANy(this))




val listX= arrayListOf<String>("maks","ruslan","azat")






        val disposable=Observable.fromArray(listX)


        disposable.subscribeOn(Schedulers.io())


            .observeOn(AndroidSchedulers.mainThread()).map { it ->
val list= arrayListOf<String>()
                it.forEach {its->

                    list.add(its+"End")



                }



list
            }
            .subscribe(object : Observer<List<String>>{
                override fun onSubscribe(d: Disposable) {}

                override fun onError(e: Throwable) {

                    Log.d("ololo",e.message.toString())




                }

                override fun onComplete() {
                    Log.d("ololo","Succes")


                }

                override fun onNext(t: List<String>) {


                    t.forEach {

                        Log.d("ololo",it.toString())
                    }


                }


            })


        val single=Single.just(listX)


          single.subscribeOn(Schedulers.io())


              .observeOn(AndroidSchedulers.mainThread()).subscribe(object:SingleObserver<List<String>>{
                  override fun onSubscribe(d: Disposable) {
                      TODO("Not yet implemented")
                  }

                  override fun onError(e: Throwable) {
                      TODO("Not yet implemented")
                  }

                  override fun onSuccess(t: List<String>) {
                      TODO("Not yet implemented")
                  }


              })



val maybe=Maybe.just(listX)



        maybe.subscribeOn(Schedulers.io())


            .observeOn(AndroidSchedulers.mainThread()).subscribe(object :MaybeObserver<List<String>>{
                override fun onSubscribe(d: Disposable) {
                    TODO("Not yet implemented")
                }

                override fun onError(e: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

                override fun onSuccess(t: List<String>) {
                    TODO("Not yet implemented")
                }


            })





            }


























    }
