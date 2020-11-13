package net.imt.fmsbookstore.data.book

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BookDao{
    @Insert(onConflict = REPLACE)
    fun insertAll(bookList: List<Book>)

    @Query("SELECT * FROM Book")
    fun findAll(): LiveData<List<Book>>
}
