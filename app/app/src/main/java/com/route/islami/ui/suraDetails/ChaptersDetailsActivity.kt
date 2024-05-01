package com.route.islami.ui.suraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.islami.R
import com.route.islami.databinding.ActivityChaptersDetailsBinding
import com.route.islami.ui.Constants

class ChaptersDetailsActivity : AppCompatActivity() {
    var chapterIndex: Int = 0
    lateinit var chapterTitle: String

    lateinit var viewBinding: ActivityChaptersDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityChaptersDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBar)

        chapterIndex = intent.getIntExtra(Constants.ChapterIndex, 0)
        chapterTitle = intent.getStringExtra(Constants.ChapterTitle) ?: " NOT FOUND"
        initViews()
        readSuraFile()
    }

    private fun readSuraFile() {
        val inputStream = assets.open("$chapterIndex.txt")
        val fileContent = inputStream.bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        initRecyclerView(lines)
    }

    private fun initRecyclerView(verses: List<String>) {
        val adapter = VersesRecyclerAdapter(verses)
        viewBinding.content.recyclerViewVerse.adapter = adapter

    }

    private fun initViews() {
        viewBinding.tvTitle.text = chapterTitle
        setTitle(null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}

