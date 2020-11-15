package net.imt.fmsbookstore.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookRepository

class BookDetailsViewModel(bookRepository: BookRepository, savedStateHandle: SavedStateHandle): ViewModel() {
    val bookIsbn: String = savedStateHandle["BOOK_ISBN"] ?: throw java.lang.IllegalArgumentException("Missing book isbn")
    val book: LiveData<Book> = bookRepository.getBook(bookIsbn)
}
