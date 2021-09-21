package com.bornidea.carrousel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bornidea.carrousel.databinding.TemplatecarrouselBinding

class AdaptadorPeliculas(
    private var lista: ArrayList<Peliculas>,
    var listener: ClickListener
) : RecyclerView.Adapter<AdaptadorPeliculas.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            TemplatecarrouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = lista[position]
        holder.bind(items)
    }

    class ViewHolder(binding: TemplatecarrouselBinding, listener: ClickListener) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        var listener: ClickListener? = null
        var imagen = binding.ImagenPelicula

        init {
            this.listener = listener
            binding.root.setOnClickListener(this)
        }

        fun bind(items: Peliculas) {
            imagen.setImageResource(items.imagen)
        }

        override fun onClick(p0: View?) {
            this.listener?.onClick(p0!!, adapterPosition)
        }
    }

    override fun getItemCount(): Int = lista.size
}