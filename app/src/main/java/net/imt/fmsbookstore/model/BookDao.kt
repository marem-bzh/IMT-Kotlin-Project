package net.imt.fmsbookstore.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(bookList: List<Book>)

    @Query("SELECT * FROM Book")
    fun getAllBooks(): LiveData<List<Book>>
}
