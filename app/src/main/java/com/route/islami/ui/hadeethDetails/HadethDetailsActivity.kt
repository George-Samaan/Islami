package com.route.islami.ui.hadeethDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.route.islami.R
import com.route.islami.databinding.ActivityHadethDetailsBinding
import com.route.islami.model.Hadeth
import com.route.islami.ui.Constants

class HadethDetailsActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityHadethDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        extractParams()
        initViews()


    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun initViews() {
        setTitle(null)
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        viewBinding.tvTitle.text = hadeth?.title
        viewBinding.content.content.text = hadeth?.content
    }

    var hadeth: Hadeth? = null

    private fun extractParams() {
        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.Hadeeth_Extra, Hadeth::class.java)
        } else {
            intent.getParcelableExtra<Hadeth>(Constants.Hadeeth_Extra)
        }
    }
}