package com.example.recipexx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FamilyMemberAdapter(private val familyMembers: List<FamilyMember>) :
    RecyclerView.Adapter<FamilyMemberAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewFamilyMember: TextView = itemView.findViewById(R.id.textViewFamilyMember)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_family_member, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val familyMember = familyMembers[position]
        holder.textViewFamilyMember.text = familyMember.name
    }

    override fun getItemCount(): Int {
        return familyMembers.size
    }
}
