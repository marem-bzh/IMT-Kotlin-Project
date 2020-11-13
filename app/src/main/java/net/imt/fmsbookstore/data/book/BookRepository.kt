package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import java.util.concurrent.Executor

class BookRepository (private val bookService: BookService, private val bookDao: BookDao, private val ioExecutor: Executor) {
    fun getAllBooks(): LiveData<List<Book>>? {
        bookService.getBooks(bookService, {
            books -> ioExecutor.execute { bookDao.insertAll(books) }
        }, { error ->
            // If there is an error, the user will have access to the locally stored books
        })

        return bookDao.getAllBooks()
    }
}
