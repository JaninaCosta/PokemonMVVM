package com.bigproject.appdelivery.ui.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bigproject.appdelivery.R
import com.bigproject.appdelivery.interfaz.OnListener
import com.bigproject.appdelivery.data.dataApiRest.model.ListadoPokemonResponse
import com.google.android.material.card.MaterialCardView

class PokemonAdapter(private val list: List<ListadoPokemonResponse>, val context: Context, val listener: OnListener)
    :RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter_lista_pokemon, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = list[position]
        holder.txvName.setText(itemData.name)
        holder.cardView.setOnClickListener { listener.onSelected(itemData) }
        try{
            val idArray = itemData.url.split("/")
            val idPokemon = idArray[6]
            holder.txvId.setText(idPokemon)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txvName = view.findViewById(R.id.txtName) as TextView
        val txvId = view.findViewById(R.id.txtId) as TextView
        val image = view.findViewById(R.id.imagen_pokemon) as ImageView
        val cardView = view.findViewById(R.id.card_view) as MaterialCardView
    }
}