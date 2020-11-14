package net.imt.fmsbookstore.ui.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.ui.book.BookListFragment

class BookDetailsActivity : AppCompatActivity() {
    companion object{
        const val BOOK_ISBN = "BOOK_ISBN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details_host)

        if(savedInstanceState == null){
            val fragment = BookDetailsFragment()

            fragment.arguments = intent.extras

            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_content, fragment)
                .commit()
        }
    }
}
