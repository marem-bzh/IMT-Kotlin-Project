package net.imt.fmsbookstore.ui.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.ui.book.BookListFragment

class BookListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_list_host)

        if(savedInstanceState == null){
            val fragment = BookListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_content, fragment)
                .commit()
        }
    }

    fun show(book: Book){
        // Handle navigation here
        val intent = Intent(this, BookDetailsActivity::class.java)
        intent.putExtra(BookDetailsActivity.BOOK_ISBN, book.isbn)
        startActivity(intent)
    }
}
