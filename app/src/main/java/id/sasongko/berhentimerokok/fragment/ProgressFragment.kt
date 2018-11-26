package id.sasongko.berhentimerokok.fragment


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import id.sasongko.berhentimerokok.R
import id.sasongko.berhentimerokok.util.SharedPreferenceApps
import kotlinx.android.synthetic.main.fragment_progress.view.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class ProgressFragment : Fragment() {

    private var currentTime = 0L
    private var seconds = 0L
    private var formattedDate =""
    private lateinit var sharedPreferenceApps: SharedPreferenceApps
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_progress, container, false)

        sharedPreferenceApps = SharedPreferenceApps(requireContext())

        getCurrentTimeUsingDate()


        currentTime = formattedDate.toLong()
        seconds = currentTime -  sharedPreferenceApps.timeStart!!.toLong()
        val handler= Handler()


        val runnableCode = object: Runnable {
            override fun run() {

                seconds += 1000
                Log.d("waktu",seconds.toString())
                timeString(seconds)
                handler.postDelayed(this, 1000)
            }
        }

        runnableCode.run()
        return view
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


    @SuppressLint("SetTextI18n")
    private fun timeString(millisUntilFinished:Long){

        var millisUntilFinish:Long = millisUntilFinished
        val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinish)
        millisUntilFinish -= TimeUnit.DAYS.toMillis(days)

        val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinish)
        millisUntilFinish -= TimeUnit.HOURS.toMillis(hours)

        val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinish)
        millisUntilFinish -= TimeUnit.MINUTES.toMillis(minutes)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinish)


        view?.fragmentProgressTvBebas?.text = "$days h : $hours j : $minutes m : $seconds s"

    }

}
