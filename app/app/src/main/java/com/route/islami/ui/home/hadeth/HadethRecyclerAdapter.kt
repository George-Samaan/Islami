package com.route.islami.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.databinding.ItemHadeethTitleBinding
import com.route.islami.model.Hadeth

class HadethRecyclerAdapter(private val hadethList: List<Hadeth>) :
    RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding: ItemHadeethTitleBinding = ItemHadeethTitleBinding.inflate(
            LayoutInflater
                .from(
                    parent.context
                ), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadeth = hadethList[position]
        holder.bind(hadeth.title)
        listener.let { listener ->
            holder.itemView.setOnClickListener {
                listener?.onClick(hadeth, position)
            }
        }

    }

    fun interface OnItemClickListener {
        fun onClick(item: Hadeth, position: Int)
    }

    var listener: OnItemClickListener? = null


    class ViewHolder(private val itemBinding: ItemHadeethTitleBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(title: String) {
            itemBinding.title.text = title

        }

    }


}