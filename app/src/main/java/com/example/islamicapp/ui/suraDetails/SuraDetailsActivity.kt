package com.example.islamicapp.ui.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamicapp.R
import com.example.islamicapp.ui.Constants

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        titleTextView = findViewById(R.id.title_text_view)
        initRecyclerView()

        val suraName = intent.getStringExtra(Constants.EXTRA_SURA_NAME)
        val suraPos = intent.getIntExtra(Constants.EXTRA_SURA_POSITION, -1)

        titleTextView.setText(suraName)
        readSureFile(suraPos)
    }

    private fun initRecyclerView() {

        recyclerView = findViewById(R.id.surah_details_recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
    }

    fun readSureFile(suraPos: Int) {

        val fileName = "${suraPos + 1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)
    }
}