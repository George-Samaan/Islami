package com.route.islami.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemChapterTitleBinding

class ChapterRecyclerAdapter(private val chaptersList: List<String>) :
    RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemChapterTitleBinding = ItemChapterTitleBinding.inflate(
            LayoutInflater
                .from(
                    parent.context
                ), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = chaptersList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = chaptersList[position]
        holder.bind(title)
        // call back
        listener.let { listener ->
            holder.itemView.setOnClickListener {
                listener?.onClick(title, position)
            }
        }
    }

    fun interface onItemClickListener {
        fun onClick(item: String, position: Int)
    }

    var listener: onItemClickListener? = null


    class ViewHolder(private val itemBinding: ItemChapterTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.title.text = title

        }

    }


}