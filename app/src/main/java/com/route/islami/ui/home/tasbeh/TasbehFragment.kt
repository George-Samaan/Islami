package com.route.islami.ui.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.R
import com.route.islami.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentTasbehBinding
    var counter = 0
    lateinit var azkarList: MutableList<String>
    var currentDhikrIndex = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        viewBinding.tvDhikr.text = azkarList[currentDhikrIndex]

        onSebhaClick()
    }

    private fun onSebhaClick() {
        viewBinding.imvBodyOfSebha.setOnClickListener {
            viewBinding.imvBodyOfSebha.rotation += (360 / 33).toFloat()

            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentDhikrIndex = if (currentDhikrIndex < azkarList.size - 1)
                    ++currentDhikrIndex else 0
                viewBinding.tvDhikr.text = azkarList[currentDhikrIndex]
            }
            viewBinding.counter.text = counter.toString()

        }
    }
}