package co.edu.udea.afinal.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PoiItem(
    @SerializedName("des")
    val des: String,
    @SerializedName("stars")
    val stars: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable