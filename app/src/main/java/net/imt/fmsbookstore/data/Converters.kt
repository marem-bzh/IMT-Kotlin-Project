package net.imt.fmsbookstore.data

import androidx.room.TypeConverter

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
}
