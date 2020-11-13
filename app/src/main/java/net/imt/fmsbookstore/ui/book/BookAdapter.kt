package net.imt.fmsbookstore.ui.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import timber.log.Timber

class BookAdapter(private var bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.BookHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_book_list_item, parent, false)
        return BookHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val book = bookList.get(position)
        holder.bindBook(book)
    }

    override fun getItemCount(): Int = bookList.size

    fun setBookList(bookList: List<Book>){
        this.bookList = bookList
        this.notifyDataSetChanged()
    }

    class BookHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var book: Book? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Timber.i("Click detected on BookListItem!") // TODO
        }

        fun bindBook(book: Book){
            this.book = book
            val bookItemCoverImageView = view.findViewById<ImageView>(R.id.bookItemCover)
            val bookItemTitleTextView = view.findViewById<TextView>(R.id.bookItemTitle)

            Picasso.get().load(book.cover).into(bookItemCoverImageView)
            bookItemTitleTextView.text = book.title
        }

        companion object {
            private val BOOK_KEY = "BOOK"
        }
    }
}
