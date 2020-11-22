package net.imt.fmsbookstore.data

import androidx.room.TypeConverter
import net.imt.fmsbookstore.data.cart.CommercialOffer
import net.imt.fmsbookstore.data.cart.Offer

object Converters {
    @TypeConverter
    @JvmStatic
    fun listToString(list: List<String>): String{
        return list.joinToString("\n")
    }

    @TypeConverter
    @JvmStatic
    fun stringToList(str: String): List<String>{
        return str.split("\n")
    }
/*
    @TypeConverter
    @JvmStatic
    fun offerToString(offer: Offer): String{
        return offer.type + "|" + offer.value + "|" + offer.sliceValue?: ""
    }*/

    /*@TypeConverter
    @JvmStatic
    fun stringToOffer(str: String): Offer{
        val offerParts = str.split("|")
        val type = offerParts[0]
        val value = offerParts[1].toInt()

        if (offerParts[2].isEmpty()) {
            return Offer(type, value, null)
        }
        else {
            return Offer(type, value, offerParts[2].toInt())
        }
    }*/
}
