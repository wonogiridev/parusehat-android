package id.sasongko.berhentimerokok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_berbagi_inspirasi.*

class BerbagiInspirasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berbagi_inspirasi)
        berbagiInspirasiBtnKirim.setOnClickListener {
            Toast.makeText(
                this,
                "Terimakasih sudah membagikan Inspirasi anda, Kami akan mereview kembali Inspirasi User agar tidak terjadi spam.",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }
    }
}
