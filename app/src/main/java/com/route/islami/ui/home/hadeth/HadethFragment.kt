package com.route.islami.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentHadethBinding
import com.route.islami.model.Hadeth
import com.route.islami.ui.Constants
import com.route.islami.ui.hadeethDetails.HadethDetailsActivity

class HadethFragment : Fragment() {

    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readHadethFile()
    }

    fun readHadethFile() {
        val hadethList = mutableListOf<Hadeth>()
        val inputStream = context?.assets?.open("ahadeeth.txt")
        val fileContent = inputStream?.bufferedReader().use {
            it?.readText()
        }
        val allAhadeeth = fileContent?.trim()?.split("#")
        allAhadeeth?.forEach { hadeth ->
            val lines = hadeth.trim().split("\n")

            if (lines.size >= 2) { // Ensure there is a title and content
                val title = lines[0].trim()
                val content = lines.subList(1, lines.size).joinToString("\n").trim()
                val hadethItem = Hadeth(title, content)
                hadethList.add(hadethItem)
            }
        }
        showHadethList(hadethList)
    }

    private fun showHadethList(hadethList: MutableList<Hadeth>) {
        val adapter = HadethRecyclerAdapter(hadethList)
        adapter.listener =
            HadethRecyclerAdapter.OnItemClickListener { item, position ->
                startHadeethDetailsActivity(item)
            }
        viewBinding.hadethRecycler.adapter = adapter
    }

    private fun startHadeethDetailsActivity(hadeeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constants.Hadeeth_Extra, hadeeth)
        startActivity(intent)


    }
}