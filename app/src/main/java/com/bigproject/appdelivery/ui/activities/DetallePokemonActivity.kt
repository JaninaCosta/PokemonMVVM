package com.bigproject.appdelivery.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bigproject.appdelivery.core.BaseActivity
import com.bigproject.appdelivery.databinding.ActivityDetallePokBinding
import com.bigproject.appdelivery.interfaz.detalle.AbilityModel
import com.bigproject.appdelivery.interfaz.detalle.DetallePokemonResponse
import com.bigproject.appdelivery.interfaz.detalle.MovesModel
import com.bigproject.appdelivery.interfaz.detalle.TypesModel
import com.bigproject.appdelivery.ui.adapter.HabilidadesAdapter
import com.bigproject.appdelivery.ui.adapter.MovimientosAdapter
import com.bigproject.appdelivery.ui.adapter.TiposPokemonAdapter
import com.bigproject.appdelivery.ui.viewmodel.DetallePokemonViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetallePokemonActivity : BaseActivity() {
    private val _viewModel: DetallePokemonViewModel by viewModels()
    private lateinit var binding: ActivityDetallePokBinding
    private var idPokemon = 0
    private lateinit var adapterTipo : TiposPokemonAdapter
    private var listaTipos = ArrayList<TypesModel>()
    private lateinit var adapterHabilidades : HabilidadesAdapter
    private lateinit var adapterMovimientos : MovimientosAdapter
    private var listaHabilidades = ArrayList<AbilityModel>()
    private var listaMovimientos = ArrayList<MovesModel>()

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetallePokBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState, binding.root, this@DetallePokemonActivity)
        configUI()
        configVM()
        if (intent.hasExtra("id_pokemon")) {
            idPokemon = intent.getStringExtra("id_pokemon")!!.toInt()
            _viewModel.obtenerDetallePokemon(idPokemon)
        }
    }

    fun configVM(){
        _viewModel.onDetallePokemos.observe(this) {
            if (this.lifecycle.currentState == Lifecycle.State.RESUMED) {
                setData(it)
            }
        }

    }

    fun configUI(){
        configRecyclerTipo()
        configRecyclerHabilidades()
        configRecyclerMovimientos()
    }

    private fun setData(data: DetallePokemonResponse) {
        if (!data.sprites.front_default.isNullOrEmpty()) {
            Glide.with(this@DetallePokemonActivity)
                .load(data.sprites.front_default)
                .fitCenter()
                .into(binding.imvPokemon)
        }

        binding.txvId.setText(data.id.toString())
        binding.txvName.setText(data.forms.get(0).name)
        binding.txvPeso.setText(data.weight.toString() + " Kg.")

        listaTipos.addAll(data.types)
        listaHabilidades.addAll(data.abilities)
        listaMovimientos.addAll(data.moves)
        adapterTipo.notifyDataSetChanged()
        adapterHabilidades.notifyDataSetChanged()
        adapterMovimientos.notifyDataSetChanged()
    }

    private fun configRecyclerTipo() {
        binding.recyclerViewTipos.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewTipos.setHasFixedSize(true)
        adapterTipo = TiposPokemonAdapter(listaTipos,this)
        binding.recyclerViewTipos.adapter = adapterTipo
    }

    private fun configRecyclerHabilidades() {
        binding.recyclerViewHabilidades.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewHabilidades.setHasFixedSize(true)
        adapterHabilidades = HabilidadesAdapter(listaHabilidades,this)
        binding.recyclerViewHabilidades.adapter = adapterHabilidades
    }

    private fun configRecyclerMovimientos() {
        binding.recyclerViewMovientos.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMovientos.setHasFixedSize(true)
        adapterMovimientos = MovimientosAdapter(listaMovimientos,this)
        binding.recyclerViewMovientos.adapter = adapterMovimientos
    }
}