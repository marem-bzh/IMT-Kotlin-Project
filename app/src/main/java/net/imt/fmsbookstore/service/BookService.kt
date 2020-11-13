package net.imt.fmsbookstore.service

import net.imt.fmsbookstore.model.Book
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface BookService {
    @GET("books")
    fun getAllBooks() : Call<List<Book>>

    companion object {
        private const val  baseUrl = "http://henri-potier.xebia.fr/"

        fun create(): BookService {
            val retrofit = Retrofit.Builder().baseUrl(baseUrl).build()

            return retrofit.create(BookService::class.java)
        }
    }
}


