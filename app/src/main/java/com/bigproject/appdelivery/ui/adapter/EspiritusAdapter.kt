package com.bigproject.appdelivery.ui.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bigproject.appdelivery.R
import com.bumptech.glide.Glide

class EspiritusAdapter(private val list: List<String>, val context: Context)
    :RecyclerView.Adapter<EspiritusAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_adapter_lista_pokemon, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = list[position]
        holder.descripcion.isVisible = false
        if (!itemData.isNullOrEmpty()) {
            Glide.with(context)
                .load(itemData)
                .fitCenter()
                .into(holder.image)
        }

    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById(R.id.imagen_pokemon) as ImageView
        val descripcion = view.findViewById(R.id.contenedorDescription) as LinearLayout
    }
}