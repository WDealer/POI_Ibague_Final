package co.edu.udea.poi.list
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.poi.model.Poi
import co.edu.udea.poi.model.PoiItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel:ViewModel() {

    private var poiLoad: MutableLiveData<ArrayList<PoiItem>> = MutableLiveData<ArrayList<PoiItem>>()
    val onPoiLoaded: LiveData<ArrayList<PoiItem>> = poiLoad

    fun loadMockPoiFromJson(poiString: InputStream?){
        val poiString = poiString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        poiLoad.value = gson.fromJson(poiString, Poi::class.java)
    }



}