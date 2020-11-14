package net.imt.fmsbookstore.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.Book
import net.imt.fmsbookstore.ui.PositionedClickListener
import timber.log.Timber

class BookDetailsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View
        val view = inflater.inflate(R.layout.fragment_book_detail, container, false)

        return view
    }
}
