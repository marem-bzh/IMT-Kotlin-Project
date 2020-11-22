package net.imt.fmsbookstore.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.imt.fmsbookstore.data.cart.CartDao
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.data.book.BookDao
import net.imt.fmsbookstore.data.cart.CartElement
import net.imt.fmsbookstore.data.cart.CommercialOffer

@Database(entities = [Book::class, CartElement::class/*, CommercialOffer::class*/], version = 5)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun bookDao(): BookDao

    abstract fun cartDao(): CartDao

}
