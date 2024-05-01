package com.route.islami.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import com.route.islami.R
import com.route.islami.databinding.ActivityMainBinding
import com.route.islami.ui.home.hadeth.HadethFragment
import com.route.islami.ui.home.quran.QuaranFragment
import com.route.islami.ui.home.radio.RadioFragment
import com.route.islami.ui.home.tasbeh.TasbehFragment

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
    }

    private fun initViews() {
        viewBinding.content.bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.navigation_quran -> QuaranFragment()
                R.id.navigation_hadeth -> HadethFragment()
                R.id.navigation_tasbeeh -> TasbehFragment()
                R.id.navigation_radio -> RadioFragment()
                else -> QuaranFragment()
            }
            pushFragment(fragment)
            true // Return true to indicate that the event is consumed
        }

        // Set the default selected item
        viewBinding.content.bottomNav.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}