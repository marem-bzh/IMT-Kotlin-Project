package net.imt.fmsbookstore.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.imt.fmsbookstore.R
import net.imt.fmsbookstore.data.book.BookRepository
import net.imt.fmsbookstore.data.cart.CartElement
import net.imt.fmsbookstore.ui.PositionedClickListener
import net.imt.fmsbookstore.ui.book.BookListViewModel
import timber.log.Timber

class CartAdapter(var cartElementList : List<CartElement>, private val listener : PositionedClickListener, private val viewModel : CartViewModel) : RecyclerView.Adapter<CartAdapter.CartHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartHolder(inflatedView, listener, viewModel)
    }

    override fun getItemCount(): Int {
        return cartElementList.size
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val cartElement = cartElementList.get(position)
        holder.bindCartElement(cartElement)
    }



    class CartHolder(v: View, private val listener: PositionedClickListener, private val viewModel: CartViewModel) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var removeProductButton : Button
        private var removeOneItemButton : Button
        private var addOneItemButton : Button

        private var cartElement:CartElement? = null

        private var bookListItemCover : ImageView
        private var cartItemTitle : TextView
        private var numberOfItems : TextView
        private var itemPrice : TextView

        private var nbOfItems = 1;

        init {
            removeProductButton = view.findViewById(R.id.removeProductButton)
            removeOneItemButton = view.findViewById(R.id.removeOneItemButton)
            addOneItemButton = view.findViewById(R.id.addOneItemButton)

            bookListItemCover = view.findViewById<ImageView>(R.id.bookListItemCover)
            cartItemTitle = view.findViewById<TextView>(R.id.cartItemTitle)
            numberOfItems = view.findViewById<TextView>(R.id.numberOfItems)
            itemPrice = view.findViewById<TextView>(R.id.itemPrice)


        }

        override fun onClick(v: View?) {
            v?: return
            listener.onClick(v, adapterPosition)
        }

        fun bindCartElement(cartElement : CartElement){

            viewModel.getBook(cartElement).observeForever({
                cartItemTitle.text = it.title
                Picasso.get().load(it.cover).into(bookListItemCover)
                itemPrice.text = (it.price*nbOfItems).toString()
                numberOfItems.text = nbOfItems.toString()
            })

            removeProductButton.setOnClickListener {
                viewModel.removeCartElement(cartElement)
            }

            /*removeOneItemButton.setOnClickListener {
                if(nbOfItems==1){
                    viewModel.removeCartElement(cartElement)
                } else {
                    nbOfItems--
                }
            }

            addOneItemButton.setOnClickListener {
                nbOfItems++
            }*/

        }

    }




}