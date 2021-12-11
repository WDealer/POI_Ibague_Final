package co.edu.udea.poi.data

class PoiRepository {

    suspend fun getPoi() = WebService.retrofit.getPoi()

}