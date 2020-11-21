package net.imt.fmsbookstore.cart

import androidx.room.Entity
import androidx.room.PrimaryKey
import net.imt.fmsbookstore.data.book.Book

@Entity
data class Cart(
    val books :List<String> //Liste d'isbn
)
