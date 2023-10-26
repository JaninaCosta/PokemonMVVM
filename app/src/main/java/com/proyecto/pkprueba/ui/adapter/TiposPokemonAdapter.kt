package com.proyecto.pkprueba.ui.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.pkprueba.R
import com.proyecto.pkprueba.interfaz.detalle.TypesModel

class TiposPokemonAdapter(private val list: List<TypesModel>, val context: Context)
    :RecyclerView.Adapter<TiposPokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter_tipos_pokemon, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = list[position]
        holder.txvTipo.setText(itemData.type.name)

    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txvTipo = view.findViewById(R.id.txtTipo) as TextView
    }
}