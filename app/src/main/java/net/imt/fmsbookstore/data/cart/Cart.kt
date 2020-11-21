package net.imt.fmsbookstore.data.cart

import androidx.room.Entity

@Entity
data class Cart(
    val books :List<String> //Liste d'isbn
)
