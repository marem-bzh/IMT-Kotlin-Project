package net.imt.fmsbookstore.data.book

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

fun getBooks(onSuccess: (books: List<Book>) -> Unit, onError: (error: String) -> Unit) {
    bookService.getBooks().enqueue(
        object: Callback<List<Book>> {
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    val books = response.body() ?: emptyList()
                    onSuccess(books)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                onError(t.message ?: "Unknown error")
            }

        }
    )
}

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
