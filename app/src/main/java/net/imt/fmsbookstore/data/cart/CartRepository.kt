package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartRepository (
    private val cartService: CartService,
    private val cartDao: CartDao
) {

    fun getCart(): LiveData<List<CartElement>> {
        return cartDao.findAll()
    }

    // TODO
    fun addCartElement(cartElement: CartElement) {
        // get all
        // add to list
        // set all
    }

    // TODO
    fun removeCartElement(cartElement: CartElement) {
        // get all
        // Remove from list
        // set all
    }

    fun getCommercialOffer() : CommercialOffer{
        GlobalScope.launch {
            val response = cartService.getComercialOffer("books/c30968db-cb1d-442e-ad0f-80e37c077f89,78ee5f25-b84f-45f7-bf33-6c7b30f1b502/commercialOffers").execute()

            if (response.isSuccessful){
                val commercialOffer = response.body() ?: CommercialOffer(emptyList())
                // TODO return value ?
            }
        }

        return CommercialOffer(emptyList())
    }
}
