package id.sasongko.berhentimerokok.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.daimajia.numberprogressbar.NumberProgressBar
import id.sasongko.berhentimerokok.R
import id.sasongko.berhentimerokok.db.MotivasiContract
import id.sasongko.berhentimerokok.model.Kesehatan
import kotlinx.android.synthetic.main.item_kesehatan.view.*
import kotlinx.android.synthetic.main.item_motivasi.view.*
import java.util.concurrent.TimeUnit

class RvAdapterKesehatan(private var waktu:Long,private var data: List<Kesehatan>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ViewHolderKesehatan(
            LayoutInflater.from(context)
                .inflate(R.layout.item_kesehatan, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val discussionModel = data[p1]
        val viewHolderKesehatan = p0 as ViewHolderKesehatan
        val temp = discussionModel.progres - waktu
        if(waktu > discussionModel.progres){
            viewHolderKesehatan.itemKesehatanTvSisaWaktu.text = "Anda berhasil Melakukan Pencapaian ini !,Selamat"
        }else{

            var millisUntilFinish: Long = temp
            val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinish)
            millisUntilFinish -= TimeUnit.DAYS.toMillis(days)

            val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinish)
            millisUntilFinish -= TimeUnit.HOURS.toMillis(hours)

            val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinish)
            millisUntilFinish -= TimeUnit.MINUTES.toMillis(minutes)

            val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinish)

            viewHolderKesehatan.itemKesehatanTvSisaWaktu.text = " dicapai dalam $days h : $hours j : $minutes m : $seconds s lagi"
        }

        val progres = (waktu * 100/ discussionModel.progres)
        Log.d("hallo",progres.toString())
        Log.d("waktu ditempuh",waktu.toString())
        Log.d("waktu target",discussionModel.progres.toString())
        if(progres > 100){
            viewHolderKesehatan.itemKesehatanProgressBar.progress = 100
        }else{
            viewHolderKesehatan.itemKesehatanProgressBar.progress = progres.toInt()
        }
        viewHolderKesehatan.itemKesehatanTvKeterangan.text = discussionModel.content
    }

}
class ViewHolderKesehatan(view: View) : RecyclerView.ViewHolder(view) {
    val itemKesehatanTvKeterangan: TextView = view.itemKesehatanTvKeterangan
    val itemKesehatanProgressBar: NumberProgressBar = view.itemKesehatanProgressBar
    val itemKesehatanTvSisaWaktu : TextView = view.itemKesehatanTvSisaWaktu
}