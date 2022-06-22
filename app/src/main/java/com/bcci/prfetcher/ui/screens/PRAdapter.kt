package com.bcci.prfetcher.ui.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bcci.prfetcher.R
import com.bcci.prfetcher.data.model.PRModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_requests.view.*

class PRAdapter(
    private val pullRequestsList : List<PRModel>) : RecyclerView.Adapter<PRViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder = PRViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_requests, parent, false)
    )


    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        holder.bindPullRequests(pullRequestsList[position])
    }

    override fun getItemCount(): Int = pullRequestsList.size
}

class PRViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bindPullRequests(prModel: PRModel) {
        itemView.tvTitle.text = prModel.title
        itemView.tvClosedOn.text = "Merged on ${prModel.closedDate}"
        itemView.tvCreatedAt.text = "Created at ${prModel.createdDate}"
        itemView.tvUsername.text = "@"+prModel.user.name
        Glide.with(itemView.context)
            .load(prModel.user.avatarUrl)
            .into(itemView.ivProfilePicture)
    }
}
