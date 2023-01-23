package com.example.lesson8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson8.OnItemTextListener
import com.example.lesson8.databinding.ItemBinding
import com.example.lesson8.fragment.LanguagesFragment
import com.example.lesson8.model.CatModel

class LanguagesAdapter(private val listLanguages: MutableList<CatModel>,
                       private val OnItemTextListener: OnItemTextListener
):
    RecyclerView.Adapter<LanguagesAdapter.LanguagesViewHolder>(), View.OnLongClickListener {
    inner class LanguagesViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(catModel: CatModel) {
            binding.txt.text = catModel.cat
            Glide.with(binding.image.context).load(catModel.cat).into(binding.image)
            itemView.setOnClickListener{
                OnItemTextListener.onClick(catModel)
                binding.txt.text = catModel.cat
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguagesViewHolder {
        return LanguagesViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LanguagesViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listLanguages[position])
        holder.itemView.setOnLongClickListener{
            listLanguages.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listLanguages.size

    override fun onLongClick(view: View?): Boolean{
        OnItemTextListener.onLongClick(view?.tag as CatModel)
        return true
    }
}