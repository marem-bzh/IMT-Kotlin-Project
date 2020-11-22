package net.imt.fmsbookstore.ui.book

import androidx.lifecycle.*
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookRepository
import net.imt.fmsbookstore.data.cart.CartElement
import net.imt.fmsbookstore.data.cart.CartRepository

class BookListViewModel(bookRepository: BookRepository, val cartRepository: CartRepository) : ViewModel() {
    val bookList : LiveData<List<Book>> = bookRepository.getBookList()

    fun addElementToCart(book: Book){
        cartRepository.addCartElement(CartElement(isbn = book.isbn))
    }

    fun nukeTable(){
        cartRepository.nukeTable()
    }
}
