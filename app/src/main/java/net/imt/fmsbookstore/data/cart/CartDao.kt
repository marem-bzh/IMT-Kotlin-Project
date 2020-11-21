package net.imt.fmsbookstore.data.cart

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cart: Cart)

    @Query("SELECT * FROM Cart")
    fun findAll(): LiveData<Cart>
}
