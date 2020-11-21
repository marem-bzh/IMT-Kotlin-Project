package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartRepository (
    private val cartService: CartService,
    private val cartDao: CartDao
) {

    fun getCart(): List<CartElement> {
        return cartDao.findAll()
    }

    fun addCartElement(cartElement: CartElement) {
        val bookList : MutableList<CartElement> = this.getCart() as MutableList<CartElement>
        // add to list
        bookList.add(cartElement)
        // set all
        this.cartDao.insertAll(bookList)
    }

    fun removeCartElement(cartElement: CartElement) {
        // get all
        val bookList : MutableList<CartElement> = this.getCart() as MutableList<CartElement>
        // Remove from list
        val updatedList = bookList.filter { element -> !element.isbn.equals(cartElement.isbn) }
        // set all
        this.cartDao.insertAll(updatedList)

    }


    //TODO
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
