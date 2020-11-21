package net.imt.fmsbookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.imt.fmsbookstore.cart.CartDao
import net.imt.fmsbookstore.cart.CartRepository
import net.imt.fmsbookstore.cart.CartService
import net.imt.fmsbookstore.ui.book.BookListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        val cartRepository : CartRepository = CartRepository()
        cartRepository.getCommercialOffer()

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrameLayout, BookListFragment())
            .commit()
    }
}
