package com.example.lesson8.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lesson8.OnItemTextListener
import com.example.lesson8.databinding.ItemBinding
import com.example.lesson8.fragment.CinemaFragment
import com.example.lesson8.model.CatModel

class CinemaAdapter(private val listCinema: MutableList<CatModel>,
                    private val OnItemTextListener: OnItemTextListener
):
    RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>(), View.OnLongClickListener {

    inner class CinemaViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(catModel: CatModel) {
            binding.txt.text = catModel.name
            Glide.with(binding.image.context).load(catModel.cat).into(binding.image)
            itemView.setOnClickListener{
                OnItemTextListener.onClick(catModel)
                binding.txt.text = catModel.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CinemaViewHolder {
        return CinemaViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CinemaViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listCinema[position])
        holder.itemView.setOnLongClickListener{
            listCinema.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listCinema.size

    override fun onLongClick(view: View?): Boolean{
        OnItemTextListener.onLongClick(view?.tag as CatModel)
        return true
    }
}