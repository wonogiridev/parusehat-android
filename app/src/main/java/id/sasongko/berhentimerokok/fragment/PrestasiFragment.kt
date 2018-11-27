package id.sasongko.berhentimerokok.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.sasongko.berhentimerokok.BerbagiInspirasiActivity

import id.sasongko.berhentimerokok.R
import kotlinx.android.synthetic.main.fragment_prestasi.view.*

class PrestasiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prestasi, container, false)
        view?.fragmentPrestasiBtnBerbagi?.setOnClickListener {
            val intent = Intent(requireContext(), BerbagiInspirasiActivity::class.java)
            startActivity(intent)
        }
        return view
    }


}
