package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

class BookRepository {
    private val bookService: BookService = TODO()

    fun getBookList(): LiveData<List<Book>> {
        val data = MutableLiveData<List<Book>>()

        bookService.getBooks().enqueue(
            object: Callback<List<Book>> {
                override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                    data.value = response.body()
                }
                override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                    TODO()
                }

            }
        )

        return data
    }
}
