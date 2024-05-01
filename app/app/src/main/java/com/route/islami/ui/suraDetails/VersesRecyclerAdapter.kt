package com.route.islami.ui.suraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemChapterTitleBinding
import com.route.islami.databinding.ItemVerseBinding

class VersesRecyclerAdapter(private val verses: List<String>) :
    RecyclerView.Adapter<VersesRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemVerseBinding = ItemVerseBinding.inflate(
            LayoutInflater
                .from(
                    parent.context
                ), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = verses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = verses[position]
        holder.bind(title)
//        listener.let {listener->
//            holder.itemView.setOnClickListener{
//                listener?.onClick(title,position)
//        }
//        }

    }

    fun interface onItemClickListener {
        fun onClick(item: String, position: Int)
    }

    var listener: onItemClickListener? = null


    class ViewHolder(private val itemBinding: ItemVerseBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.content.text = title

        }

    }


}