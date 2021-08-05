package com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.R
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.domain.models.Gist
import com.evgeniykim.mvpmoxyrxjavaretrofitdaggerpicasso.presentation.gistDetails.GistDetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class MainActivity : MvpAppCompatActivity(), GistListView {
    private var mAdapter: GistListAdapter? = null

    @InjectPresenter
    lateinit var gistsPresenter: GistListPresenter

    @ProvidePresenter
    fun provideListPresenter(): GistListPresenter {
        return GistListPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rw_trending.layoutManager = LinearLayoutManager(this)
        mAdapter = GistListAdapter(ArrayList(), this) {
            gistsPresenter.userClicked(it)
        }
        rw_trending.adapter = mAdapter
        swipe_refresh.setOnRefreshListener {
            gistsPresenter.loadUsers()
        }
    }

    override fun showGists(gists: List<Gist>) {
        mAdapter?.setData(gists)
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun startLoading() {
        swipe_refresh.isRefreshing = true
    }

    override fun finishLoading() {
        swipe_refresh.isRefreshing = false
    }

    override fun showUserDetails(id: String) {
        val intent = Intent(this, GistDetailsActivity::class.java)
        intent.putExtra(GistDetailsActivity.DETAILS, id)
        startActivity(intent)
    }
}