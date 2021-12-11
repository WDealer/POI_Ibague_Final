package co.edu.udea.poi.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.udea.poi.databinding.FragmentListBinding
import co.edu.udea.poi.main.MainActivity
import co.edu.udea.poi.model.PoiItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var poiAdapter: PoiAdapter
    private var listpoi: ArrayList<PoiItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding= FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockPoiFromJson(context?.assets?.open("poi.json"))

        listViewModel.onPoiLoaded.observe(viewLifecycleOwner,{result ->
            onPoiLoadedSubscribe(result)
        })
        poiAdapter = PoiAdapter(listpoi,onItemClicked = {onPoiClicked(it)})

        listBinding.poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }

    }

    private fun onPoiLoadedSubscribe(result: ArrayList<PoiItem>?) {
        result?.let{listPoi ->
            poiAdapter.appendItems(listPoi)
            /*TODO: revisar feedback
            this.listpoi = listPoi
            poiAdapter.notifyDataSetChanged()*/

        }


    }

    private fun onPoiClicked(poi:PoiItem){
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))

    }



}