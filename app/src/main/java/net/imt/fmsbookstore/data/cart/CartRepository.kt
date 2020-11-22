package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class CartRepository (
    private val cartService: CartService,
    private val cartDao: CartDao
) {

    fun getCart(): LiveData<List<CartElement>> {
        return cartDao.findAll()
    }

    fun addCartElement(cartElement: CartElement) {
        GlobalScope.launch {
            cartDao.insert(cartElement)
            Timber.i("Cart Repository - add Cart Element")
            Timber.i(cartElement.isbn)
        }
    }

    fun removeCartElement(cartElement: CartElement) {
        GlobalScope.launch {
            cartDao.delete(cartElement.isbn)
        }
    }

    fun nukeTable(){
        GlobalScope.launch {
            cartDao.nukeTable()
        }
    }
}
