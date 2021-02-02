package com.example.kotlinapp_tetu.Presentation.Main.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp_tetu.Data.Local.Model.Pokemon
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp_tetu.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_pokemon_item.view.*

class PokemonAdapter(private val context:Context, private val PokeList: MutableList<Pokemon>):
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = PokeList[position].name
        holder.url.text = PokeList[position].url
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.layout_pokemon_item, parent,false)
            return ViewHolder(
                itemView
            )
    }
    override fun getItemCount(): Int{
        return PokeList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name: TextView
        var url: TextView


        init{
            name = itemView.txt_name
            url = itemView.txt_url
        }
    }
}

