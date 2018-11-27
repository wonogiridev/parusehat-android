package id.sasongko.berhentimerokok

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_date_time_picker.*
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.text.TextUtils
import android.util.Log
import android.widget.TimePicker
import android.widget.Toast
import id.sasongko.berhentimerokok.util.Constanta
import java.text.SimpleDateFormat
import java.util.*


class DateTimePickerActivity : AppCompatActivity() {

    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour: Int = 0
    private var mMinute: Int = 0

    private lateinit var sharedPreferences: SharedPreferences
    private var formattedDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_picker)

        sharedPreferences = applicationContext.getSharedPreferences(
            Constanta.PREF_APP,
            Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPreferences.edit()
        getCurrentTimeUsingDate()

        dateTimeEtDate.setOnClickListener {
            val c = Calendar.getInstance()
            mYear = c.get(Calendar.YEAR)
            mMonth = c.get(Calendar.MONTH)
            mDay = c.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    setTime()

                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }
        dateTimeBtnSimpan.setOnClickListener {
            if(TextUtils.isEmpty(dateTimeEtRokokTiapHari.text.toString()) || TextUtils.isEmpty(dateTimeEtRokokPerPack.text.toString())
            || TextUtils.isEmpty(dateTimeEtHargaPerPack.text.toString())){
                Toast.makeText(this,"Data Tidak Boleh Ada Yang Kosong!",Toast.LENGTH_SHORT).show()
            } else {
                sharedPrefEditor.putString(Constanta.BANYAK_ROKOK,dateTimeEtRokokTiapHari.text.toString())
                sharedPrefEditor.putString(Constanta.ISI_PERPACK,dateTimeEtRokokPerPack.text.toString())
                sharedPrefEditor.putString(Constanta.HARGA,dateTimeEtHargaPerPack.text.toString())
                sharedPrefEditor.putString(Constanta.FIRST_TIME, "no")
                sharedPrefEditor.putString(Constanta.TIME_START, formattedDate)
                sharedPrefEditor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun setTime() {
        val c = Calendar.getInstance()
        mHour = c.get(Calendar.HOUR_OF_DAY)
        mMinute = c.get(Calendar.MINUTE)

        // Launch Time Picker Dialog
        val timePickerDialog = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                Log.d("TAG", "BODOAMAT")
            },
            mHour,
            mMinute,
            false
        )
        timePickerDialog.show()
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
