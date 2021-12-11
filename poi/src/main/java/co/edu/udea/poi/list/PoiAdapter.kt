package co.edu.udea.poi.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.udea.poi.R
import co.edu.udea.poi.model.PoiItem
import com.squareup.picasso.Picasso

class PoiAdapter(
    private val poiList: ArrayList<PoiItem>,
    private val onItemClicked:(PoiItem) -> Unit
): RecyclerView.Adapter<PoiAdapter.PoiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,viewType:Int):PoiViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item,parent,false)
        return PoiViewHolder (view)
    }
    override fun onBindViewHolder(holder:PoiViewHolder,position: Int){
        val poi = poiList[position]
        holder.itemView.setOnClickListener {onItemClicked(poiList[position])}
        holder.bind(poi)
    }
    override fun getItemCount(): Int = poiList.size

    fun appendItems(newItems:ArrayList<PoiItem>){
        poiList.clear()
        poiList.addAll(newItems)
        notifyDataSetChanged()
    }

    class PoiViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView =itemView.findViewById(R.id.name_text_view)
        private var desTextView: TextView =itemView.findViewById(R.id.des_text_view)
        private var starsTextView: TextView =itemView.findViewById(R.id.stars_text_view)
        private var pictureImageView: ImageView =itemView.findViewById(R.id.picture_image_view)

        fun bind(poi:PoiItem){
            nameTextView.text = poi.name
            desTextView.text = poi.des
            starsTextView.text = poi.stars
            Picasso.get().load(poi.urlPicture).into(pictureImageView)
        }
    }
}