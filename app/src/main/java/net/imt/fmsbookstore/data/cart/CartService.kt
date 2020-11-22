package net.imt.fmsbookstore.data.cart

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface CartService {
    @GET("books/{books}/commercialOffers")
    fun getComercialOffer(@Path("books") url:String) : Call<CommercialOffer>
}
