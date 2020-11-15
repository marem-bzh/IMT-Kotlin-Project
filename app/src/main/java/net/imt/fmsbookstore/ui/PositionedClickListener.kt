package net.imt.fmsbookstore.ui

import android.view.View

/**
 * Listener to handle clicks on positioned elements inside a list
 */
interface PositionedClickListener {
    /**
     * @param v The view that has been clicked
     * @param position The position of the elements in its parent list
     */
    fun onClick(v: View, position: Int)
}
