package com.example.appanotaciones2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appanotaciones2.model.Anotacion

class AnotListAdapter : ListAdapter<Anotacion, AnotListAdapter.AnotViewHolder>(WordsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnotViewHolder {
        return AnotViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AnotViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.tarea)
    }

    class AnotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val anotItemView: TextView = itemView.findViewById(R.id.tvDescripcionTarea)

        fun bind(text: String?) {
            anotItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): AnotViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_notas, parent, false)
                return AnotViewHolder(view)
            }
        }
    }

    class WordsComparator : DiffUtil.ItemCallback<Anotacion>() {
        override fun areItemsTheSame(oldItem: Anotacion, newItem: Anotacion): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Anotacion, newItem: Anotacion): Boolean {
            return oldItem.tarea == newItem.tarea
        }
    }
}