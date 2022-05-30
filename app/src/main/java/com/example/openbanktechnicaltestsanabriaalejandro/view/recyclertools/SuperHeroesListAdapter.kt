package com.example.openbanktechnicaltestsanabriaalejandro.view.RecyclerViewTools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openbanktechnicaltestsanabriaalejandro.R
import com.example.openbanktechnicaltestsanabriaalejandro.model.MyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.view.recyclertools.SuperHeroListHolder

class SuperHeroesListAdapter(val list: List<MyTypeHeroData>) :
    RecyclerView.Adapter<SuperHeroListHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperHeroListHolder {
        val layout = LayoutInflater.from(parent.context)
        return SuperHeroListHolder(layout.inflate(R.layout.view_for_all_heroes_list, parent, false))
    }

    override fun onBindViewHolder(
        holder: SuperHeroListHolder,
        position: Int
    ) {
        holder.paintIt(list[position])
    }

    override fun getItemCount(): Int = list.size
}