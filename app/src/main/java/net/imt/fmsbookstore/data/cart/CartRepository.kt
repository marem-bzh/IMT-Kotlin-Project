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

    val currentOffer: MutableLiveData<CommercialOffer> by lazy {
        MutableLiveData<CommercialOffer>()
    }

    fun getCart(): LiveData<List<CartElement>> {
        return cartDao.findAll()
    }

    fun addCartElement(cartElement: CartElement) {
        GlobalScope.launch {
            cartDao.insert(cartElement)
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

    fun getCommercialOffer(cartElementList : List<CartElement>){
        GlobalScope.launch {
            val isbnList = cartElementList.map { cartElement -> cartElement.isbn }
            val queryString = isbnList.joinToString(",")
            val response = cartService.getComercialOffer(queryString).execute()
            if(response.isSuccessful){
                val commercialOffer = response.body() ?: CommercialOffer(offers = emptyList())
                /*cartDao.insertCommercialOffer(commercialOffer)*/
            }
        }
    }

}
