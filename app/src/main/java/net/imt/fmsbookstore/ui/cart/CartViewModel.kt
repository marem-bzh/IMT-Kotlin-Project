package net.imt.fmsbookstore.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.imt.fmsbookstore.data.cart.CartElement
import net.imt.fmsbookstore.data.cart.CartRepository

class CartViewModel(val cartRepository: CartRepository) : ViewModel() {
    val cartElementList: List<CartElement> = cartRepository.getCart();

    fun addCartElement (cartElement: CartElement) {
        cartRepository.addCartElement(cartElement);
    }

    fun removeCartElement (cartElement: CartElement) {
        cartRepository.removeCartElement(cartElement);
    }
}