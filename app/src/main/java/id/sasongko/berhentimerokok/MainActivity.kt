package id.sasongko.berhentimerokok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.view.View
import id.sasongko.berhentimerokok.extensions.replaceFragmentSafely
import id.sasongko.berhentimerokok.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    companion object Factory {
        private const val TAG_FRAGMENT_MOTIVASI = "fragment_home"
        private const val TAG_FRAGMENT_KESEHATAN = "fragment_kesehatan"
        private const val TAG_FRAGMENT_PROGRESS = "fragment_progress"
        private const val TAG_FRAGMENT_TABUNGAN = "fragment_tabungan"
        private const val TAG_FRAGMENT_PRESTASI = "fragment_prestasi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main_activity)
        main_bottom_navigation.selectedItemId = R.id.menu_progress
        main_bottom_navigation.setOnNavigationItemSelectedListener(this)
        replaceFragmentSafely(
            fragment = ProgressFragment(),
            tag = TAG_FRAGMENT_PROGRESS,
            containerViewId = R.id.main_frame_container,
            enterAnimation = android.R.anim.fade_in,
            exitAnimation = android.R.anim.fade_out
        )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_motivasi -> {
                replaceFragmentSafely(
                    fragment = MotivasiFragment(),
                    tag = TAG_FRAGMENT_MOTIVASI,
                    containerViewId = R.id.main_frame_container,
                    enterAnimation = android.R.anim.fade_in,
                    exitAnimation = android.R.anim.fade_out
                )
                return true

            }
            R.id.menu_kesehatan -> {
                replaceFragmentSafely(
                    fragment = KesehatanFragment(),
                    tag = TAG_FRAGMENT_KESEHATAN,
                    containerViewId = R.id.main_frame_container,
                    enterAnimation = android.R.anim.fade_in,
                    exitAnimation = android.R.anim.fade_out
                )
                return true
            }
            R.id.menu_progress -> {
                replaceFragmentSafely(
                    fragment = ProgressFragment(),
                    tag = TAG_FRAGMENT_PROGRESS,
                    containerViewId = R.id.main_frame_container,
                    enterAnimation = android.R.anim.fade_in,
                    exitAnimation = android.R.anim.fade_out
                )
                return true
            }
            R.id.menu_tabungan -> {
                replaceFragmentSafely(
                    fragment = TabunganFragment(),
                    tag = TAG_FRAGMENT_TABUNGAN,
                    containerViewId = R.id.main_frame_container,
                    enterAnimation = android.R.anim.fade_in,
                    exitAnimation = android.R.anim.fade_out
                )
                return true
            }
            R.id.menu_prestasi -> {
                replaceFragmentSafely(
                    fragment = PrestasiFragment(),
                    tag = TAG_FRAGMENT_PRESTASI,
                    containerViewId = R.id.main_frame_container,
                    enterAnimation = android.R.anim.fade_in,
                    exitAnimation = android.R.anim.fade_out
                )
                return true
            }
        }
        return false
    }

}
