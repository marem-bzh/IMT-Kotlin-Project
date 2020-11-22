package net.imt.fmsbookstore.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.cart.CartElement
import net.imt.fmsbookstore.ui.PositionedClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class CartFragment: Fragment() {
    private val viewModel: CartViewModel by viewModel()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.cart, container, false)
        linearLayoutManager = LinearLayoutManager(this.context)
        recyclerView = view.findViewById(R.id.cartRecyclerView)
        recyclerView.layoutManager = linearLayoutManager

        val cartElements = ArrayList<CartElement>()
        cartAdapter = CartAdapter(cartElements, object: PositionedClickListener{
            override fun onClick(v: View, position: Int) {
                val cartElement = cartAdapter.cartElementList

                if(v.id == R.id.removeProductButton){
                    Timber.i("Test")
                }
            }

        })


        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}