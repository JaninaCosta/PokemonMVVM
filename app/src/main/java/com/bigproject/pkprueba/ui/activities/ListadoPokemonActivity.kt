package com.bigproject.pkprueba.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.bigproject.pkprueba.core.BaseActivity
import com.bigproject.pkprueba.core.EndlessRecyclerOnScrollListener
import com.bigproject.pkprueba.data.dataApiRest.model.ListadoPokemonResponse
import com.bigproject.pkprueba.databinding.ActivityListadoPokBinding
import com.bigproject.pkprueba.interfaz.OnListener
import com.bigproject.pkprueba.ui.adapter.PokemonAdapter
import com.bigproject.pkprueba.ui.viewmodel.ListadoPokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListadoPokemonActivity : BaseActivity(), OnListener {
    private lateinit var binding: ActivityListadoPokBinding
    private lateinit var adapter: PokemonAdapter
    private var listaData = ArrayList<ListadoPokemonResponse>()
    private var infiniteScrollListener: EndlessRecyclerOnScrollListener? = null
    private val _viewModel: ListadoPokemonViewModel by viewModels()
    private var nextPage = ""

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityListadoPokBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState, binding.root, this@ListadoPokemonActivity)
        configRecycler()
        configVM()
        _viewModel.obtenerListadoPokemon(0, 40)
    }

    private fun configVM(){
        _viewModel.onListadoPokemon.observe(this) {
            if (this.lifecycle.currentState == Lifecycle.State.RESUMED) {
                listaData.addAll(it.results)
                if(it.next != null){
                    nextPage = it.next!!
                }
                adapter.notifyDataSetChanged()
            }
        }
    }


    private fun configRecycler() {
        with(binding.recyclerView) {
            layoutManager = GridLayoutManager(this@ListadoPokemonActivity, 3)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            itemAnimator = null
            setHasFixedSize(true)
        }

        infiniteScrollListener = object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                if (nextPage != null) {
                    try{
                        val linkNextPage = nextPage!!.split("=")
                        val linkNextPage_Offset = linkNextPage[1].split("&")
                        val nextPage = linkNextPage_Offset[0]
                        _viewModel.obtenerListadoPokemon(Integer.parseInt(nextPage), 40)
                    }catch (e: Exception){
                        e.printStackTrace()
                    }
                }
            }
        }
        binding.recyclerView.addOnScrollListener(infiniteScrollListener as EndlessRecyclerOnScrollListener)
        adapter = PokemonAdapter(listaData, this, this)
        binding.recyclerView.adapter = adapter
    }

    fun getIdPokemon(url: String) : String{
        var idPokemon = "0"
        try{
            val idArray = url.split("/")
            idPokemon = idArray[6]
        }catch (e: Exception){
            e.printStackTrace()
        }
        return idPokemon
    }

    override fun onSelected(pokemon: ListadoPokemonResponse) {
        val intent = Intent(this, DetallePokemonActivity::class.java)
        intent.putExtra("id_pokemon", getIdPokemon(pokemon.url))
        startActivity(intent)
    }
}