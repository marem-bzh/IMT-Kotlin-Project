package net.imt.fmsbookstore.data.book

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey val isbn: String,
    val title: String,
    val price: Double,
    val cover: String,
    // val synopsis: List<String> // TODO serialize synopsis
)
