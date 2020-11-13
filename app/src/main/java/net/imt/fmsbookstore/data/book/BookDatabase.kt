package net.imt.fmsbookstore.data.book

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
