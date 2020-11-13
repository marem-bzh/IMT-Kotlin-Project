package net.imt.fmsbookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.getBooks

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
