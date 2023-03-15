package com.example.chsb_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chsb_project.databinding.ActivityMyCardsBinding

class MyCards : AppCompatActivity() {
    lateinit var binding: ActivityMyCardsBinding
    lateinit var newRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMyCardsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var cards= mutableListOf<CardData>()

        cards.add(CardData("Visa","Visa","123456789",R.drawable.img_card,R.drawable.img_3))


        val adapter=CardAdapter(this,cards)
        binding.cardRv.adapter=adapter
        newRecyclerView=binding.cardRv
        newRecyclerView.layoutManager=LinearLayoutManager(this)

    }
    }
