package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CartRepository (
    private val cartService: CartService,
    private val cartDao: CartDao
) {

    fun getCart(): LiveData<List<CartElement>> {
        return cartDao.findAll()
    }

    fun addCartElement(cartElement: CartElement) {
        GlobalScope.launch {
            val cartElementList : MutableLiveData<List<CartElement>> = getCart() as MutableLiveData<List<CartElement>>
            // add to list
            cartElementList.observeForever({
                it as MutableList<CartElement>
                it.add(cartElement)
            })

            cartDao.insertAll(cartElementList)
        }
        // set all
    }

    fun removeCartElement(cartElement: CartElement) {
        GlobalScope.launch{
            val cartElementList : MutableLiveData<List<CartElement>> = getCart() as MutableLiveData<List<CartElement>>
            cartElementList.observeForever({
                it as MutableLiveData<CartElement>

                it.filter { element -> !element.isbn.equals(cartElement.isbn) }
                //TODO réussir à retourner it
            })
            cartDao.insertAll(cartElementList)
        }

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

    /*
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
    }*/
}
