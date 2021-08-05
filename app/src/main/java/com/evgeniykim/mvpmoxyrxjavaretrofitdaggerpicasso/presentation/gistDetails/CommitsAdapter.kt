package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.R
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Commit
import kotlinx.android.synthetic.main.item_commit.view.*

class CommitsAdapter(private val commits: List<Commit>) : RecyclerView.Adapter<CommitsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_commit, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(commits[position])
    }

    override fun getItemCount(): Int {
        return commits.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(commit: Commit) {
            with(commit) {
                itemView.item_commit_minus_tv.text = deletions
                itemView.item_commit_plus_tv.text = additions
                itemView.item_commit_name_tv.text = version
            }
        }
    }


}