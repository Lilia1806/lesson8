package com.example.lesson8

import com.example.lesson8.model.CatModel

interface OnItemTextListener {
    fun onClick(model: CatModel)
    fun onLongClick(model: CatModel) : Boolean

}