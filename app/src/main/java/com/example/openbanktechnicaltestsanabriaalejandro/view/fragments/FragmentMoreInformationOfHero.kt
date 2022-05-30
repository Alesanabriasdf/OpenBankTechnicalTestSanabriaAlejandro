package com.example.openbanktechnicaltestsanabriaalejandro.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.openbanktechnicaltestsanabriaalejandro.R
import com.example.openbanktechnicaltestsanabriaalejandro.databinding.FragmentMoreInformationOfHeroBinding
import com.example.openbanktechnicaltestsanabriaalejandro.view.MainActivity.Companion.prefs
import com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.SuperHeroDetailViewModel


class FragmentMoreInformationOfHero : Fragment(R.layout.fragment_more_information_of_hero) {

    private lateinit var binding: FragmentMoreInformationOfHeroBinding

    private val superHeroDescriptionViewModel: SuperHeroDetailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMoreInformationOfHeroBinding.bind(view)

        prefs.colectId(arguments?.getString("descriptionOfSuperHero")!!)

        superHeroDescriptionViewModel.onGetDetail()

        superHeroDescriptionViewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar2.isVisible = it
        }

        superHeroDescriptionViewModel.showDescriptionItems.observe(viewLifecycleOwner) {
            binding.tvForDescriptionOfHero.isVisible = it
            binding.imageOfMarvel.isVisible=it
            binding.labelDescription.isVisible = it
            binding.invitationToMoreUse.isVisible = it
        }

        superHeroDescriptionViewModel.descriptionOfHero.observe(viewLifecycleOwner){
            binding.tvForDescriptionOfHero.text= it!!.descriptionOfHero
        }

        superHeroDescriptionViewModel.showSorryItems.observe(viewLifecycleOwner){
            binding.sorry.isVisible=it
            binding.sorry.text=getString(R.string.sorry)
            binding.tvIfThereIsNoDescription.isVisible=it
            binding.tvIfThereIsNoDescription.text=getString(R.string.there_is_no_description_string)
        }

        superHeroDescriptionViewModel.thereIsNoInternet.observe(viewLifecycleOwner) {
            binding.tvForError.isVisible = it
        }
    }
}