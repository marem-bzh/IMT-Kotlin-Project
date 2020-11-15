package net.imt.fmsbookstore.ui.book

import androidx.lifecycle.*
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookRepository

class BookListViewModel(bookRepository: BookRepository) : ViewModel() {
    val bookList : LiveData<List<Book>> = bookRepository.getBookList()
}
