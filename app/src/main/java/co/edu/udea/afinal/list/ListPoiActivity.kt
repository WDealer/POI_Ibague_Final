package co.edu.udea.afinal.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.afinal.R
import co.edu.udea.afinal.detalle.DetalleActivity
import co.edu.udea.afinal.model.Poi
import co.edu.udea.afinal.model.PoiItem
import com.google.gson.Gson

class ListPoiActivity : AppCompatActivity(){

    private lateinit var listpoi: ArrayList<PoiItem>
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var poiRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poi)
        poiRecyclerView = findViewById(R.id.poi_recycler_view)
        listpoi = loadMockPoiFromJson()
        poiAdapter = PoiAdapter(listpoi,onItemClicked = {onPoiClicked(it)})

        poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }
    private fun onPoiClicked(poi:PoiItem){
        val intent = Intent(this,DetalleActivity::class.java)
        intent.putExtra("poi",poi)
        startActivity(intent)
    }
    private fun loadMockPoiFromJson():ArrayList<PoiItem>{
        val poiString: String = applicationContext.assets.open("poi.json").bufferedReader().use {it.readText()}
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Poi::class.java)
        return poiList
    }
}