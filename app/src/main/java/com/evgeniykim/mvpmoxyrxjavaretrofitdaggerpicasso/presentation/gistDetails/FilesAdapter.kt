package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.R
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.GistFileInfo
import kotlinx.android.synthetic.main.item_details_header.view.*

class FilesAdapter(private val files: List<GistFileInfo>,
private val expandedList: MutableList<Boolean>,
private val clickListener: (Int) -> Unit) : RecyclerView.Adapter<FilesAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_details_header, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(files[position], expandedList[position])
        holder.itemView.setOnClickListener { clickListener(position) }
    }

    override fun getItemCount(): Int {
        return files.size
    }

    fun changeItem(isExpanded: Boolean, position: Int) {
        expandedList.set(position, isExpanded)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fileInfo: GistFileInfo, isExpanded: Boolean) {
            itemView.item_details_header_tv.text = fileInfo.fileName

            if (!isExpanded) {
                itemView.item_details_content_tv.visibility = View.GONE

//                itemView.item_details_arrow_iv.setImageResource(R.drawable.arrow_up)
            } else {
                if (itemView.item_details_content_tv.text.toString().isEmpty()) {
                    itemView.item_details_content_tv.text = fileInfo.content
                }
                itemView.item_details_content_tv.visibility = View.VISIBLE

            }
        }
    }
}