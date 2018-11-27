package id.sasongko.berhentimerokok

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import id.sasongko.berhentimerokok.db.MotivasiContract
import id.sasongko.berhentimerokok.db.database
import kotlinx.android.synthetic.main.activity_add_motivasi.*
import org.jetbrains.anko.db.insert

class AddMotivasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_motivasi)
        addMotivasiBtnTambah.setOnClickListener {
            addMotivasi(addMotivasiEt.text.toString())
            finish()
        }
    }

    private fun addMotivasi(content: String) {
        try {
            database.use {
                insert(MotivasiContract.TABLE_MOTIVASI,
                    MotivasiContract.CONTENT to content)
            }
        } catch (e: SQLiteConstraintException){
            Log.d("ANDA KURANG BERUNTUNG", "HEHE")
        }
    }
}
