package com.aftarfadilah.anmp_w2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.aftarfadilah.anmp_w2.databinding.FragmentNameBinding
import com.aftarfadilah.anmp_w2.databinding.FragmentOptionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A simple [Fragment] subclass.
 * Use the [OptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OptionFragment : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentOptionBinding
    private val LEVEL = arrayOf("Easy", "Medium", "Hard")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter:ArrayAdapter<String> = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_dropdown_item_1line, LEVEL)
        binding.txtLevel.setAdapter(adapter)
    }
}