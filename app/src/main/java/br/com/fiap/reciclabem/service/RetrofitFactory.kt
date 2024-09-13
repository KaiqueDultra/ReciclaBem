package br.com.fiap.reciclabem.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getAddressService(): EnderecoService {
        return retrofitFactory.create(EnderecoService::class.java)
    }
}