package net.imt.fmsbookstore.ui.book

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import net.imt.fmsbookstore.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class BookDetailsFragment : Fragment() {
    private val viewModel: BookDetailsViewModel by viewModel(state = { arguments as Bundle })
    private lateinit var bookTitleTextView: TextView
    private lateinit var bookCoverImageView: ImageView
    private lateinit var bookSynopsisTextView: TextView
    private lateinit var bookPriceTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // View
        val view = inflater.inflate(R.layout.book_details, container, false)

        bookTitleTextView = view.findViewById(R.id.bookTitle)
        bookPriceTextView = view.findViewById(R.id.bookPrice)
        bookCoverImageView = view.findViewById(R.id.bookCover)
        bookSynopsisTextView = view.findViewById(R.id.bookSynopsis)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.book.observe(viewLifecycleOwner) {
            bookTitleTextView.text = it.title
            bookPriceTextView.text = it.price.toString()
            Picasso.get().load(it.cover).into(bookCoverImageView)
            bookSynopsisTextView.text = it.synopsis.joinToString(" ")
        }
    }
}
