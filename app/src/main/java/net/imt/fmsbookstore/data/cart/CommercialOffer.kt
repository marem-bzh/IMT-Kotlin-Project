package net.imt.fmsbookstore.data.cart

import androidx.room.Entity


@Entity
data class CommercialOffer (

    val commerCialOffers: Offer

)

@Entity
data class Offer (
    val offers : List<OfferItem>
)

@Entity
data class OfferItem (
    val type : String,
    val value : Int,
    val sliceValue : Int
)

