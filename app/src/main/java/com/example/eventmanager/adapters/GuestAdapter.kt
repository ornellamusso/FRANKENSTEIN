package com.example.eventmanager.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventmanager.data.entities.Event
import com.example.eventmanager.data.entities.Guest
import com.example.eventmanager.databinding.ItemGuestBinding

class TaskAdapter(
    var items: List<Event>,
    //val onItemClick: (Int) -> Unit,
    val onItemDelete: (Int) -> Unit,
    val onItemEdit: (Int) -> Unit
) : RecyclerView.Adapter<GuestViewHolder>() {
    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val task = items[position]
        holder.init(task)
        /*holder.itemView.setOnClickListener {
            onItemClick(position)
        }*/
        holder.binding.deleteButton.setOnClickListener {
            onItemDelete(position)
        }
        holder.binding.editButton.setOnClickListener {
            onItemEdit(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val binding = ItemGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<Guest>) {
        this.items = items
        notifyDataSetChanged()
    }

}

class GuestViewHolder(val binding: ItemGuestBinding) : RecyclerView.ViewHolder(binding.root) {

    fun init(guest: Event) {
        binding.
    }
}