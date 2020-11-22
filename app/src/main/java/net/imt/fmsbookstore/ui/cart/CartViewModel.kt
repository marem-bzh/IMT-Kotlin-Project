package net.imt.fmsbookstore.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookRepository
import net.imt.fmsbookstore.data.cart.CartElement
import net.imt.fmsbookstore.data.cart.CartRepository

class CartViewModel(val cartRepository: CartRepository, val bookRepository: BookRepository) : ViewModel() {
    val cartElementList: LiveData<List<CartElement>> = cartRepository.getCart();

    fun addCartElement (cartElement: CartElement) {
        cartRepository.addCartElement(cartElement)
    }

    fun removeCartElement (cartElement: CartElement) {
        cartRepository.removeCartElement(cartElement)
    }

    fun getBook(cartElement: CartElement) : LiveData<Book>{
        return bookRepository.getBook(cartElement.isbn)
    }

    /*
    fun getCart() : List<CartElement>{
        return cartRepository.getCart()
    }*/
}