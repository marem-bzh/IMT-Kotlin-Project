package net.imt.fmsbookstore.data.book

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.imt.fmsbookstore.data.Converters

@Database(entities = [Book::class], version = 2)
@TypeConverters(Converters::class)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
