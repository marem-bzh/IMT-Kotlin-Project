package net.imt.fmsbookstore.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.imt.fmsbookstore.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment: Fragment() {
    private val viewModel: BookListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.bookList.observe(viewLifecycleOwner) {
            // populate the list view here
        }
    }
}

