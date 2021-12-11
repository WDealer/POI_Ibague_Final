package co.edu.udea.poi.data

import co.edu.udea.poi.model.Poi
import retrofit2.http.GET

interface ApiService {

    @GET("/WDealer/POI_Final/poi")
    suspend fun getPoi(): Poi
}