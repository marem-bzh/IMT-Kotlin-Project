package net.imt.fmsbookstore.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.imt.fmsbookstore.MainActivity
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.ui.PositionedClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class BookListFragment: Fragment() {
    private val viewModel: BookListViewModel by viewModel()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookListAdapter: BookListAdapter
    private lateinit var cartButton : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View
        val view = inflater.inflate(R.layout.book_list, container, false)
        linearLayoutManager = LinearLayoutManager(this.context)
        recyclerView = view.findViewById(R.id.bookListRecyclerView)
        recyclerView.layoutManager = linearLayoutManager
        cartButton = view.findViewById(R.id.cartButton)

        cartButton.setOnClickListener{
            (requireActivity() as MainActivity).navController.navigate(R.id.action_bookListFragment_to_cartFragment)
        }


        // Data
        val books = ArrayList<Book>()

        // Behaviour
        bookListAdapter = BookListAdapter(books, object: PositionedClickListener{
            override fun onClick(v: View, position: Int) {
                val book = bookListAdapter.bookList.get(position)

                if (v.id == R.id.bookListItemButton){
                    Timber.i("Add ${book.title} to basket") // TODO
                } else{
                    val bundle = Bundle().apply {putString("BOOK_ISBN", book.isbn)}
                    (requireActivity() as MainActivity).navController.navigate(R.id.action_bookListFragment_to_bookDetailsFragment, bundle)
                }
            }
        })
        recyclerView.adapter = bookListAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Once the view is created, we start observing the book list data in the viewModel to add content to the list
        viewModel.bookList.observe(viewLifecycleOwner) {
            bookListAdapter.bookList = it
            bookListAdapter.notifyDataSetChanged()
        }
    }
}


