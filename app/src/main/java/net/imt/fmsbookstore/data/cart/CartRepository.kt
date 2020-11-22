package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CartRepository (
    private val cartService: CartService,
    private val cartDao: CartDao
) {

    fun getCart(): List<CartElement> {
        return cartDao.findAll()
    }

    fun addCartElement(cartElement: CartElement) {
        var bookList : MutableList<CartElement> = this.getCart() as MutableList<CartElement>
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
    /*fun getCommercialOffer() : CommercialOffer{
        val bookList = this.getCart()
        GlobalScope.launch {
            var queryParameter : String = ""
            bookList.forEach{element -> {
               queryParameter = element.isbn + ','
            }}
            val response = cartService.getComercialOffer(queryParameter+"/commercialOffers").execute()

            if (response.isSuccessful){
                val commercialOffer = response.body() ?: CommercialOffer(emptyList())
                // TODO return value ?
            }
        }

        return CommercialOffer(emptyList())
    }*/

    fun getCommercialOffer() : CommercialOffer{
        val bookList = this.getCart()
        val deferred = GlobalScope.async {
            var queryParameter : String = ""
            bookList.forEach{element -> {
                queryParameter = element.isbn + ','
            }}
            val response = cartService.getComercialOffer(queryParameter+"/commercialOffers").execute()

            if (response.isSuccessful){
                val commercialOffer = response.body() ?: CommercialOffer(emptyList())
                // TODO return value ?
            }
        }

        return CommercialOffer(emptyList())
    }
}
