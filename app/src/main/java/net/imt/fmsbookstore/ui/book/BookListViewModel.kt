package net.imt.fmsbookstore.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookRepository

class BookListViewModel (private val bookRepository: BookRepository) : ViewModel() {
    val bookList : LiveData<List<Book>> = bookRepository.getBookList()
}