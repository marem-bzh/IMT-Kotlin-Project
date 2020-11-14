package net.imt.fmsbookstore.ui.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.ui.PositionedClickListener

/**
 * @param listener The listener that handles clicks on the items and buttons of the list
 */
class BookListAdapter(var bookList: List<Book>, private val listener : PositionedClickListener) : RecyclerView.Adapter<BookListAdapter.BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.BookHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item, parent, false)
        return BookHolder(inflatedView, listener)
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val book = bookList.get(position)
        holder.bindBook(book)
    }

    override fun getItemCount(): Int = bookList.size

    class BookHolder(v: View, private val listener: PositionedClickListener) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var button: Button
        private var book: Book? = null

        init {
            button = v.findViewById(R.id.bookListItemButton)

            v.setOnClickListener(this)
            button.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            v?: return

            listener.onClick(v, adapterPosition)
        }

        fun bindBook(book: Book){
            this.book = book
            val bookItemCoverImageView = view.findViewById<ImageView>(R.id.bookListItemCover)
            val bookItemTitleTextView = view.findViewById<TextView>(R.id.bookListItemTitle)

            Picasso.get().load(book.cover).into(bookItemCoverImageView)
            bookItemTitleTextView.text = book.title
        }

        companion object {
            private val BOOK_KEY = "BOOK"
        }
    }
}
