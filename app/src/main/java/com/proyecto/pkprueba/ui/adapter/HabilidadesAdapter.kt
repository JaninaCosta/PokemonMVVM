package com.proyecto.pkprueba.ui.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.pkprueba.R
import com.proyecto.pkprueba.interfaz.detalle.AbilityModel

class HabilidadesAdapter(private val list: List<AbilityModel>, val context: Context)
    :RecyclerView.Adapter<HabilidadesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter_habilidades_pokemon, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = list[position]
        holder.txvHabilidades.setText(itemData.ability.name)

    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txvHabilidades = view.findViewById(R.id.txtHabilidades) as TextView
    }
}