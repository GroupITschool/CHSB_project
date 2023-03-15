package com.example.chsb_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(var context: Context, var cards: MutableList<CardData>) : RecyclerView.Adapter<CardAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val background_img: ImageView = itemView.findViewById(R.id.bg_img)
        val name: TextView = itemView.findViewById(R.id.card_name)
        val category:TextView = itemView.findViewById(R.id.card_category)
        val icon_img: ImageView = itemView.findViewById(R.id.card_icon)
        val card_num: TextView = itemView.findViewById(R.id.card_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false))
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var cards = cards[position]
        holder.background_img.setImageResource(cards.background)
        holder.name.text = cards.name
        holder.category.text = cards.category
        holder.card_num.text=cards.number
        holder.icon_img.setImageResource(cards.icon)

    }
}