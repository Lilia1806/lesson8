package com.example.lesson8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson8.OnItemTextListener
import com.example.lesson8.databinding.ItemBinding
import com.example.lesson8.fragment.CatFragment
import com.example.lesson8.model.CatModel

class CatAdapter(private val listCat: MutableList<CatModel>,
                 private val onItemTextListener : OnItemTextListener
): RecyclerView.Adapter<CatAdapter.CatViewHolder>(), OnLongClickListener{

    inner class CatViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txt.text = catModel.name
            Glide.with(binding.image.context).load(catModel.cat).into(binding.image)
            itemView.setOnClickListener{
                onItemTextListener.onClick(catModel)
                binding.txt.text = catModel.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listCat[position])
        holder.itemView.setOnLongClickListener{
            listCat.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listCat.size

    override fun onLongClick(v: View?): Boolean {
        onItemTextListener.onLongClick(v?.tag as CatModel)
        return true
    }


}