package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber
import javax.security.auth.callback.Callback

class BookRepository (
    private val bookService: BookService,
    private val bookDao: BookDao
) {

    /**
     * @return An observable LiveData representing the list of all books available in the app
     */
    fun getBookList(): LiveData<List<Book>> {
        refreshBookList()

        return bookDao.findAll()
    }

    /**
     * Updates the list of books in the local storage using the bookService
     */
    private fun refreshBookList() {
        GlobalScope.launch {
            val response = bookService.getBooks().execute()

            if (response.isSuccessful) {
                val booksList = response.body() ?: emptyList()
                bookDao.insertAll(booksList)
            }
        }
    }
}

