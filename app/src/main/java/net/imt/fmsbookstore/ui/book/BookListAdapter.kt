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
import net.imt.fmsbookstore.ui.cart.CartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.w3c.dom.Text

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

        private var bookItemCoverImageView: ImageView
        private var bookItemTitleTextView: TextView
        private var bookItemPriceTextView: TextView



        init {
            button = v.findViewById(R.id.bookListItemButton)

            bookItemCoverImageView = view.findViewById<ImageView>(R.id.bookListItemCover)
            bookItemTitleTextView = view.findViewById<TextView>(R.id.bookListItemTitle)
            bookItemPriceTextView = view.findViewById<TextView>(R.id.bookListItemPrice)

            v.setOnClickListener(this)
            button.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            v?: return

            listener.onClick(v, adapterPosition)
        }

        fun bindBook(book: Book){
            this.book = book

            Picasso.get().load(book.cover).into(bookItemCoverImageView)
            bookItemTitleTextView.text = book.title
            bookItemPriceTextView.text = book.price.toString()
        }

        companion object {
            private val BOOK_KEY = "BOOK"
        }
    }
}
