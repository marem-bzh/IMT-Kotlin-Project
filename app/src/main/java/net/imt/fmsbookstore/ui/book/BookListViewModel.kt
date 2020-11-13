package net.imt.fmsbookstore.ui.book

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.HiltAndroidApp
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookRepository

/*class BookListViewModel (private val bookRepository: BookRepository) : ViewModel() {
    val bookList : LiveData<List<Book>> = bookRepository.getBookList()

    companion object {
        fun create(modelClass: Class<T>): ViewModel {
            @Suppress("UNCHECKED_CAST")
            return BookListViewModel(bookRepository)
        }
    }
}*/
class BookListViewModel @ViewModelInject constructor(bookRepository: BookRepository) : ViewModel() {
    val bookList : LiveData<List<Book>> = bookRepository.getBookList()
}
