package id.sasongko.berhentimerokok

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.sasongko.berhentimerokok.util.Constanta
import id.sasongko.berhentimerokok.util.SharedPreferenceApps
import kotlinx.android.synthetic.main.activity_welcome.*
import java.text.SimpleDateFormat
import java.util.*

class WelcomeActivity : AppCompatActivity() {


    private lateinit var sharedPreferences: SharedPreferences
    private var formattedDate = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        sharedPreferences = applicationContext.getSharedPreferences(Constanta.PREF_APP,
            Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()
        getCurrentTimeUsingDate()
        buttonNext.setOnClickListener {
            sharedPrefEditor.putString(Constanta.FIRST_TIME, "no")
            sharedPrefEditor.putString(Constanta.TIME_START, formattedDate)
            sharedPrefEditor.apply()
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }

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
