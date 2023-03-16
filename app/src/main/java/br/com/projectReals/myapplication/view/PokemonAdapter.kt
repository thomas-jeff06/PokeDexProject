package br.com.projectReals.myapplication.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.projectReals.myapplication.R
import br.com.projectReals.myapplication.domain.Pokemon
import com.bumptech.glide.Glide

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon?) = with(itemView){
            val ivPokemonImage = findViewById<ImageView>(R.id.ivPokemonImage)
            val tvId = findViewById<TextView>(R.id.tvId)
            val tvName = findViewById<TextView>(R.id.tvName)
            val tvType = findViewById<TextView>(R.id.tvType)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            item?.let {
                Glide.with(itemView).load(it.imageUrl).into(ivPokemonImage)

                tvId.text = "Nº ${item.formattedNumber}"
                tvName.text = item.formattedName
                tvType.text = item.types[0].name.capitalize()

                if(item.types.size > 1){
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = item.types[1].name.capitalize()
                } else{
                    tvType2.visibility = View.GONE
                }
            }
        }
    }
}