package net.imt.fmsbookstore.data.cart

import android.util.Log
import androidx.lifecycle.LiveData
import java.util.concurrent.Executor
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val cartService: CartService,
    private val executor: Executor,
    private val cartDao: CartDao
) {

    fun getCart(): LiveData<Cart> {
        //refreshCommercialOffer()

        return cartDao.findAll()
    }

    fun getCommercialOffer() {
        refreshCommercialOffer()
    }


    private fun refreshCommercialOffer() {
        executor.execute {
            val response = cartService.getComercialOffer("books/c30968db-cb1d-442e-ad0f-80e37c077f89,78ee5f25-b84f-45f7-bf33-6c7b30f1b502/commercialOffers").execute()
            val responseBody = response.body()

            if (responseBody == null) {
                return@execute
            }

            Log.v("DEBUG ::::::::", responseBody.toString())


            //cartDao.insertAll(responseBody)
        }
    }
}
