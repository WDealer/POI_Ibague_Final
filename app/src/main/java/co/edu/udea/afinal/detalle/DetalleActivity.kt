package co.edu.udea.afinal.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.udea.afinal.databinding.ActivityDetalleBinding
import co.edu.udea.afinal.model.PoiItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {

    private lateinit var detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val poi: PoiItem = intent.extras?.getSerializable("poi") as PoiItem

        with(detalleBinding){
            nameTextView.text = poi.name
            desTextView.text = poi.des
            starsTextView.text = poi.stars
            Picasso.get().load(poi.urlPicture).into(pictureImageView)
        }


    }
}