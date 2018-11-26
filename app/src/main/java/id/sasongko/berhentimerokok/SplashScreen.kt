package id.sasongko.berhentimerokok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import id.sasongko.berhentimerokok.util.SharedPreferenceApps

class SplashScreen : AppCompatActivity() {

    private lateinit var sharedPreferenceApps: SharedPreferenceApps

    private val splashDelay: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharedPreferenceApps = SharedPreferenceApps(this)

        if(sharedPreferenceApps.firstTime.equals("yes",true)){
            val intent = Intent(applicationContext,WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val mDelayHandler = Handler()
        val runnableCode = object: Runnable {
            override fun run() {

                mDelayHandler.postDelayed(this, 1000)
            }
        }

        runnableCode.run()

    }
}
