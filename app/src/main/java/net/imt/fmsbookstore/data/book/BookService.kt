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

    companion object {
        private const val  baseUrl = "http://henri-potier.xebia.fr/"

        fun create(): BookService {
            val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit.create(BookService::class.java)
        }
    }
}

val bookService by lazy {
    BookService.create()
}
