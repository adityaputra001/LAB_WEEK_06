package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Attach swipe-to-delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Tambahkan data (minimal 10 items sesuai assignment)
        catAdapter.setData(listOf(
            CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
            CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
            // Tambah sampai 10 (boleh duplikasi untuk latihan)
            CatModel(Gender.Female, CatBreed.AmericanCurl, "Mimi", "Sleepy", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Tom", "Lazy hunter", "https://cdn2.thecatapi.com/images/6qi.jpg"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Playful and loud", "https://cdn2.thecatapi.com/images/1b.jpg"),
            CatModel(Gender.Male, CatBreed.AmericanCurl, "Rocky", "Curious climber", "https://cdn2.thecatapi.com/images/2si.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Nina", "Tiny but fierce", "https://cdn2.thecatapi.com/images/3m0.jpg"),
            CatModel(Gender.Unknown, CatBreed.BalineseJavanese, "Shadow", "Mystery cat", "https://cdn2.thecatapi.com/images/4ab.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Bella", "Loves naps", "https://cdn2.thecatapi.com/images/5cd.jpg")
        ))
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK", null)
            .show()
    }
}

//comment