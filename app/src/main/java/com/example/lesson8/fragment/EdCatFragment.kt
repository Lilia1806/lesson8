package com.example.lesson8.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson8.R
import com.example.lesson8.databinding.FragmentEdCatBinding

class EdCatFragment : Fragment() {

    private var binding: FragmentEdCatBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEdCatBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener() {
        binding?.btCat?.setOnClickListener {
            val bundle1 = Bundle()
            bundle1.putString("cat2", binding?.edCat?.text.toString())
            findNavController().navigate(R.id.action_edCatFragment_to_catFragment, bundle1)
        }
    }
}