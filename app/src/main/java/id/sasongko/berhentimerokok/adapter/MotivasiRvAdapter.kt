package id.sasongko.berhentimerokok.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.sasongko.berhentimerokok.R
import id.sasongko.berhentimerokok.db.MotivasiContract
import kotlinx.android.synthetic.main.item_motivasi.view.*

class RvAdapterDiscussion(private var data: List<MotivasiContract>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ViewHolderDiscussion(
            LayoutInflater.from(context)
                .inflate(R.layout.item_motivasi, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val discussionModel = data[p1]
        val viewHolderDiscussion = p0 as ViewHolderDiscussion

        viewHolderDiscussion.itemMotivasiContent.text = discussionModel.content
        viewHolderDiscussion.itemMotivasiNumber.text = discussionModel.id.toString()
    }

}
class ViewHolderDiscussion (view: View) : RecyclerView.ViewHolder(view) {
    val itemMotivasiContent: TextView = view.itemMotivasiText
    val itemMotivasiNumber: TextView = view.itemMotivasiNomor
}