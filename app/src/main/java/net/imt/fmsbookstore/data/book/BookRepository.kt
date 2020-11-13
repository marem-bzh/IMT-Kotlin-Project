package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookRepository (
    private val bookService: BookService,
    private val bookDao: BookDao
) {

    fun getBookList(): LiveData<List<Book>> {
        refreshBookList()

        return bookDao.findAll()
    }

    private fun refreshBookList() {
        /*GlobalScope.launch {
            val response = bookService.getBooks().execute()
            val responseBody = response.body()

            if (responseBody != null) {
                bookDao.insertAll(responseBody)
            }
        }*/
    }
}

