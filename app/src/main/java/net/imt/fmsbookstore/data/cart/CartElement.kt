package net.imt.fmsbookstore.data.cart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartElement(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val isbn: String
)
