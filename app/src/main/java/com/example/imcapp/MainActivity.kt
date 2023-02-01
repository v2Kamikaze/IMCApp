package com.example.imcapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imcapp.models.MainItem

class MainActivity : AppCompatActivity() {

    lateinit var btnNext: LinearLayoutCompat
    lateinit var mainRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext = findViewById(R.id.btn_next)

        btnNext.setOnClickListener {
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent)
        }
        
        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_wb_sunny_24,
                textStringId = R.string.normal,
                color = Color.WHITE
            )
        )

        mainItems.add(
            MainItem(
                id = 2,
                drawableId = R.drawable.baseline_wb_sunny_24,
                textStringId = R.string.btn_imc_label,
                color = Color.WHITE
            )
        )

        mainItems.add(
            MainItem(
                id = 3,
                drawableId = R.drawable.baseline_wb_sunny_24,
                textStringId = R.string.app_name,
                color = Color.WHITE
            )
        )

        mainItems.add(
            MainItem(
                id = 4,
                drawableId = R.drawable.baseline_wb_sunny_24,
                textStringId = R.string.btn_imc_label,
                color = Color.WHITE
            )
        )

        mainRecyclerView = findViewById(R.id.main_recycler_view)
        mainRecyclerView.adapter = MainAdapter(mainItems)
        mainRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }


    private inner class MainAdapter(private val mainItemsList: List<MainItem>) :
        RecyclerView.Adapter<MainViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        override fun getItemCount() = mainItemsList.size

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val item = mainItemsList[position]
            holder.bind(item)
        }

    }

    private class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: MainItem) {
            val listItem = view as ConstraintLayout
            val cardView: CardView = view.findViewById(R.id.main_item_card)
            val imageView: AppCompatImageView = listItem.findViewById(R.id.main_item_img)
            val textView: AppCompatTextView = listItem.findViewById(R.id.main_item_label)

            cardView.setCardBackgroundColor(item.color)
            imageView.setImageResource(item.drawableId)
            textView.setText(item.textStringId)

        }
    }
}