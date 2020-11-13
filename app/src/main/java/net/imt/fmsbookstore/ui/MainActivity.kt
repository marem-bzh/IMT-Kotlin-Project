package net.imt.fmsbookstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.ui.book.BookListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrameLayout, BookListFragment())
            .commit()
    }
}
