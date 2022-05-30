package com.example.openbanktechnicaltestsanabriaalejandro.view.recyclertools

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.openbanktechnicaltestsanabriaalejandro.databinding.ViewForAllHeroesListBinding
import com.example.openbanktechnicaltestsanabriaalejandro.model.MyTypeHeroData
import com.example.openbanktechnicaltestsanabriaalejandro.view.fragments.FragmentSuperHeroesListDirections
import com.squareup.picasso.Picasso

class SuperHeroListHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var binding = ViewForAllHeroesListBinding.bind(view)

    fun paintIt(hero: MyTypeHeroData) {
        // to draw the image
        Picasso.get().load(hero.image).into(binding.ivSuperHero)

        //set the name of the hero in the text

        binding.tvSuperHeroName.text = hero.superHeroName
        binding.btnToMoreInfo.text = "More info about: " + hero.superHeroName


        //set the navigation to the next fragment

        binding.btnToMoreInfo.setOnClickListener {

            it.findNavController().navigate(
                FragmentSuperHeroesListDirections
                    .actionFragmentSuperHeroesListToFragmentMoreInformationOfHero(hero.id)
            )
        }
    }
}