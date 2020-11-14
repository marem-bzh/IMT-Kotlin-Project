package net.imt.fmsbookstore.ui.book

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.imt.fmsbookstore.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class BookDetailsFragment : Fragment() {
    private val viewModel: BookDetailsViewModel by viewModel(state = { arguments as Bundle })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View
        val view = inflater.inflate(R.layout.fragment_book_detail, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.book.observe(viewLifecycleOwner) {
            Timber.i("${it?.title ?: "Unknown book"}")
        }
    }
}
