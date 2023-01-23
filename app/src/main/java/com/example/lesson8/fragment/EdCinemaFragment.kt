package com.example.lesson8.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson8.R
import com.example.lesson8.databinding.FragmentEdCinemaBinding

class EdCinemaFragment : Fragment() {
    private var binding: FragmentEdCinemaBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEdCinemaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        binding?.btCinema?.setOnClickListener {
            val bundle1 = Bundle()
            bundle1.putString("cat2", binding?.edCinema?.text.toString())
            findNavController().navigate(R.id.action_edCinemaFragment_to_cinemaFragment, bundle1)
        }
    }
}