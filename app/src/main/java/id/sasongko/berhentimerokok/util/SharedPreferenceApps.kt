package id.sasongko.berhentimerokok.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceApps @SuppressLint("CommitPrefEdits")
constructor(context: Context) {
    private val sharedPreferences: SharedPreferences
            = context.getSharedPreferences(Constanta.PREF_APP, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor
    val firstTime: String?
        get() = sharedPreferences.getString(Constanta.FIRST_TIME, "yes")

    val timeStart: String?
        get() = sharedPreferences.getString(Constanta.TIME_START, "0")


    init {
        this.editor = sharedPreferences.edit()
    }

}
