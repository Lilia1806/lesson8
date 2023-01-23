package com.example.lesson8.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson8.OnItemTextListener
import com.example.lesson8.R
import com.example.lesson8.adapter.LanguagesAdapter
import com.example.lesson8.databinding.FragmentLenguageaBinding
import com.example.lesson8.model.CatModel
import com.example.lesson8.repository.LanguagesRepository

class LanguagesFragment : Fragment(),OnItemTextListener {
    private var binding: FragmentLenguageaBinding? = null
    private val textList = ArrayList<CatModel>()
    private val adapter = LanguagesAdapter(textList, this)
    private val repo = LanguagesRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLenguageaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()
        getData()
        initialize()
    }

    private fun click() {
        binding?.btnToThirdFragLang?.setOnClickListener {
            findNavController().navigate(R.id.action_catFragment_to_edCatFragment)
        }
    }

    private fun getData() {
        val bundle = arguments
        if (arguments != null) {
            val text = bundle?.getString("cat2")
            textList.add(CatModel(textList.toString(),text.toString()))
        }
    }
    private fun initialize() {
        binding?.rvLanguage?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfText())
        binding?.rvLanguage?.adapter = adapter
    }


    override fun onClick(textModel: CatModel) {
        val bundle = Bundle()
        bundle.putString("cat", textModel.name)
        findNavController().navigate(R.id.action_PROGRAMMING_LANGUAGESFragment_to_detailLanguagesFragment)
    }

    override fun onLongClick(model: CatModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
