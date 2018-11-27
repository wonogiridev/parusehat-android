package id.sasongko.berhentimerokok.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.sasongko.berhentimerokok.R
import id.sasongko.berhentimerokok.adapter.RvAdapterDiscussion
import id.sasongko.berhentimerokok.db.MotivasiContract
import id.sasongko.berhentimerokok.db.database
import kotlinx.android.synthetic.main.fragment_motivasi.*
import kotlinx.android.synthetic.main.fragment_motivasi.view.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import id.sasongko.berhentimerokok.AddMotivasiActivity

class MotivasiFragment : Fragment() {

    private var favorites: MutableList<MotivasiContract> = mutableListOf()
    private lateinit var adapter: RvAdapterDiscussion

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_motivasi, container, false)
        adapter = RvAdapterDiscussion(favorites, requireContext())
        view?.fragmentMotivasiRv?.layoutManager = LinearLayoutManager(requireContext())
        view?.fragmentMotivasiRv?.adapter = adapter
        showFavorite()
        view?.fragmentMotivasiFab?.setOnClickListener {
            val intent = Intent(requireContext(), AddMotivasiActivity::class.java)
            startActivity(intent)
        }
        return view
    }

    override fun onResume() {
        showFavorite()
        super.onResume()
    }

    private fun showFavorite(){
        favorites.clear()
        context?.database?.use {
            val result = select(MotivasiContract.TABLE_MOTIVASI)
            val favorite = result.parseList(classParser<MotivasiContract>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }

}
