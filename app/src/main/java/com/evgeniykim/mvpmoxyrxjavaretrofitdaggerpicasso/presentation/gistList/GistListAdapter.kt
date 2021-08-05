package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.R
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Gist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_gist.view.*

class GistListAdapter(private var items: List<Gist>, private val context: Context, val listener: (Gist) -> Unit) :
RecyclerView.Adapter<GistListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gist, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(data: List<Gist>) {
        items = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(gist: Gist) {
            with(itemView) {
                item_gist_name_tv.text = gist.description
                item_gist_author_login_tv.text = gist.owner.login

                if (gist.owner.avatarUrl != "") {
                    Picasso.get()
                        .load(gist.owner.avatarUrl)
                        .resize(150, 150)
                        .centerInside()
                        .into(item_gist_avatar_iv)
                }

                itemView.setOnClickListener { listener(gist) }
            }
        }

    }
}