package net.imt.fmsbookstore.ui.book

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment: Fragment() {
    private val viewModel: BookListViewModel by viewModel()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)

        linearLayoutManager = LinearLayoutManager(this.context)
        recyclerView = view.findViewById(R.id.bookRecyclerView)
        recyclerView.layoutManager = linearLayoutManager

        val books = ArrayList<Book>()
        /*books.add(Book("", "Book1", 0.0, ""))
        books.add(Book("", "Book2", 0.0, ""))
        books.add(Book("", "Book3", 0.0, ""))*/

        bookAdapter = BookAdapter(books)
        recyclerView.adapter = bookAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bookList.observe(viewLifecycleOwner) {
            bookAdapter.setBookList(it)
            /*bookAdapter = BookAdapter(it)
            recyclerView.adapter = bookAdapter*/
            /*it.forEach {
                Timber.i(it.toString())
            }*/
            // populate the list view here
        }
    }
}


