package br.com.fiap.reciclabem.service

import br.com.fiap.reciclabem.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EnderecoService {

    @GET("json?")
    fun getEnderecoByLatLng(
        @Query("keyword") keyword: String,
        @Query("location") location: String,
        @Query("rankby") rankby: String,
        @Query("key") key: String
    ): Call<Endereco>

}