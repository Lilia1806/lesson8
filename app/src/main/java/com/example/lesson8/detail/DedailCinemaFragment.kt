package com.example.lesson8.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lesson8.R
import com.example.lesson8.databinding.FragmentDedailCinemaBinding
import com.example.lesson8.model.CatModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DedailCinemaFragment : Fragment() {
    private lateinit var binding: FragmentDedailCinemaBinding
    private var model: CatModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDedailCinemaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data
        click()
    }

    private fun click() {
        binding.closeCinema.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val data: Unit
        get() {
            val argument = arguments
            if (argument != null) {
                model = argument.getSerializable("key") as CatModel
                binding.imageDetail.let {
                    it.context.let { it1 ->
                        Glide.with(it1).load(model?.name).into(binding.imageDetail)
                    }
                }
                binding.txtNameDetail.text = model?.name
            }
        }
}