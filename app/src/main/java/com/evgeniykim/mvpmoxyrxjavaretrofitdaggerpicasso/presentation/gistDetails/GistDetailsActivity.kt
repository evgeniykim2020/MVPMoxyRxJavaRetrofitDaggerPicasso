package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistDetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.R
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Commit
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.GistDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class GistDetailsActivity : MvpAppCompatActivity(), GistDetailsView {

    @InjectPresenter
    lateinit var gistDetailsPresenter: GistDetailsPresenter

    private var filesAdapter: FilesAdapter? = null

    companion object {
        const val DETAILS = "DETAILS_ID"
    }

    @ProvidePresenter
    fun provideDetailsPresenter(): GistDetailsPresenter {

        return GistDetailsPresenter(intent.getStringExtra(DETAILS)!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }

    override fun showDetails(gistDetails: GistDetails, expandedList: MutableList<Boolean>) {
        if (gistDetails.owner.avatarUrl != "") {
            Picasso.get()
                .load(gistDetails.owner.avatarUrl)
                .resize(300, 300)
                .centerInside()
                .into(activity_gist_details_avatar_iv)
        }

        activity_gist_details_author_name_tv.text = gistDetails.owner.login
        activity_gist_details_gist_name_tv.text = gistDetails.description

        activity_gist_files_rv.layoutManager = LinearLayoutManager(this)
        filesAdapter = FilesAdapter(gistDetails.files, expandedList) {
            gistDetailsPresenter.expandedClicked(it)
        }

        activity_gist_files_rv.adapter = filesAdapter
    }

    override fun showCommitInfo(commits: List<Commit>) {
        activity_gist_commits_rv.layoutManager = LinearLayoutManager(this)

        val adapter = CommitsAdapter(commits)
        activity_gist_commits_rv.adapter = adapter
    }

    override fun showLoading() {
        activity_gist_pb.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        activity_gist_pb.visibility = View.GONE
        activity_gist_container_sv.visibility = View.VISIBLE
    }

    override fun changeItemContent(isExpanded: Boolean, pos: Int) {
        filesAdapter?.changeItem(isExpanded, pos)
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        finish()
    }
}