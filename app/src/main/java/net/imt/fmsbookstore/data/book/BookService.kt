package net.imt.fmsbookstore.data.book

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

interface BookService {
    @GET("books")
    fun getBooks() : Call<List<Book>>
}
