package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.imt.fmsbookstore.data.book.Book

@Dao
interface CartDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cartElementList: List<CartElement>)

    @Query("SELECT * FROM CartElement")
    fun findAll(): LiveData<List<CartElement>>

    @Query("DELETE FROM CartElement WHERE isbn=:isbn")
    fun delete(isbn:String)

    @Insert()
    fun insert(cartElement: CartElement)

    @Query("DELETE FROM CartElement")
    fun nukeTable();

    @Insert
    fun insertCommercialOffer(commercialOffer: CommercialOffer)
}
