package net.imt.fmsbookstore.data.cart

import androidx.room.Entity


@Entity
data class CommercialOffer (
    val offers: List<Offer>
)

@Entity
data class Offer (
    val type : String,
    val value : Int,
    val sliceValue : Int?
)
