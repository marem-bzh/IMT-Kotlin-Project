package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.system.exitProcess

class BookRepository @Inject constructor(
    private val bookService: BookService,
    private val executor: Executor,
    private val bookDao: BookDao
) {

    fun getBookList(): LiveData<List<Book>> {
        refreshBookList()

        return bookDao.findAll()
    }


    private fun refreshBookList() {
        executor.execute {
            val response = bookService.getBooks().execute()
            val responseBody = response.body()

            if (responseBody == null) {
                return@execute
            }

            bookDao.insertAll(responseBody)
        }
    }
}
