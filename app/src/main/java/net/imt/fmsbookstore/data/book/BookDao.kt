package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.imt.fmsbookstore.data.book.Book

@Dao
interface BookDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bookList: List<Book>)

    @Query("SELECT * FROM Book")
    fun findAll(): LiveData<List<Book>>
}
