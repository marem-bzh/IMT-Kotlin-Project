package net.imt.fmsbookstore.cart

import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface CartService {

    @GET
    fun getComercialOffer(@Url url:String) : Call<CommercialOffer>

    companion object {
        private const val  baseUrl = "http://henri-potier.xebia.fr/"

        fun create(): CartService {
            val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(CartService::class.java)
        }
    }
}

val cartService by lazy {
    CartService.create()
}