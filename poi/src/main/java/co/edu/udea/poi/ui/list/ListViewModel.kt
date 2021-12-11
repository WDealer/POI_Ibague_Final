package co.edu.udea.poi.ui.list
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.udea.poi.data.PoiRepository
import co.edu.udea.poi.model.Poi
import co.edu.udea.poi.model.PoiItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel:ViewModel() {

    private var poiLoad: MutableLiveData<ArrayList<PoiItem>> = MutableLiveData<ArrayList<PoiItem>>()
    val onPoiLoaded: LiveData<ArrayList<PoiItem>> = poiLoad

    private val repository = PoiRepository()

    fun getPoiFromServer(){
        GlobalScope.launch(Dispatchers.IO){
            poiLoad.postValue(repository.getPoi())
        }
    }

    fun loadMockPoiFromJson(poiString: InputStream?){
        val poiString = poiString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        poiLoad.value = gson.fromJson(poiString, Poi::class.java)
    }



}