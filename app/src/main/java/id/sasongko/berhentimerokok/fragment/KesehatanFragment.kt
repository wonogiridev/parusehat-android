package id.sasongko.berhentimerokok.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.sasongko.berhentimerokok.R
import id.sasongko.berhentimerokok.adapter.RvAdapterKesehatan
import id.sasongko.berhentimerokok.model.Kesehatan
import id.sasongko.berhentimerokok.util.SharedPreferenceApps
import kotlinx.android.synthetic.main.fragment_kesehatan.view.*
import kotlinx.android.synthetic.main.fragment_progress.view.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class KesehatanFragment : Fragment() {

    private var data:MutableList<Kesehatan> = mutableListOf()
    private lateinit var adapter:RvAdapterKesehatan
    private lateinit var sharedPreferenceApps: SharedPreferenceApps
    private var currentTime = 0L
    private var seconds = 0L
    private var formattedDate = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kesehatan, container, false)
        sharedPreferenceApps = SharedPreferenceApps(requireContext())


        setData()

        getCurrentTimeUsingDate()


        currentTime = formattedDate.toLong()
        seconds = currentTime - sharedPreferenceApps.timeStart!!.toLong()
        adapter = RvAdapterKesehatan(seconds,data,requireContext())
        view.rviewKesehatan.layoutManager = LinearLayoutManager(requireContext())
        view.rviewKesehatan.adapter = adapter
        return view
    }

    private fun setData() {
        val data1 :Kesehatan = Kesehatan("Setelah 20 menit : Tekanan darah dan detak jantung Anda menurun menjadi normal",1200000,"")
        data.add(data1)
        val data2 :Kesehatan = Kesehatan("Setelah 8 jam : Tingkat karbon monoksida dalam darah Anda kembali normal",28800000," ")
        data.add(data2)
        val data3 :Kesehatan = Kesehatan("Setelah 24 jam : Perubahan serangan jantung Anda menurun",86400000," ")
        data.add(data3)
        val data4 :Kesehatan = Kesehatan("Setelah 48 jam : Kemampuan Anda untuk mencicipi dan mencium mulai kembali",172800000," ")
        data.add(data4)
        val data5 :Kesehatan = Kesehatan("Setelah 72 jam : Saluran udara Anda mulai rileks",259200000," ")
        data.add(data5)
        val data6 :Kesehatan = Kesehatan("Setelah 5 sampai 8 hari : jumlah rata-rata mengidam berkurang menjadi 3 roko per hari",432000000," ")
        data.add(data6)
        val data7 :Kesehatan = Kesehatan("Setelah 10 sampai 14 hari : Sirkulasi darah di gusi dan gigi Anda kembali normal. Mengidam berkurang menjadi 2 per hari rata-rata)",864000000," ")
        data.add(data7)
        val data8 :Kesehatan = Kesehatan("Setelah 2 sampai 12 minggu : Sirkulasi darah Anda membaik dan fungsi paru Anda meningkat",1209600000," ")
        data.add(data8)
    }


    @SuppressLint("SetTextI18n")
    private fun timeString(millisUntilFinished: Long) {

        var millisUntilFinish: Long = millisUntilFinished
        val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinish)
        millisUntilFinish -= TimeUnit.DAYS.toMillis(days)

        val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinish)
        millisUntilFinish -= TimeUnit.HOURS.toMillis(hours)

        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinish)
        millisUntilFinish -= TimeUnit.MINUTES.toMillis(minutes)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinish)


    }
    @SuppressLint("SimpleDateFormat")
    fun getCurrentTimeUsingDate() {

        val strDateFormat = "yyyy-MM-dd HH:mm:ss"
        val dateFormat = SimpleDateFormat(strDateFormat)
        val currentDate = dateFormat.format(Date())
        val currentTime = dateFormat.parse(currentDate)
        val temp = currentTime.time
        formattedDate = temp.toString()
    }

}
