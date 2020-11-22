package net.imt.fmsbookstore.data.cart

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CommercialOffer (
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val offers: List<Offer>
)

@Entity
data class Offer (
    val type : String,
    val value : Int,
    val sliceValue : Int?
)
