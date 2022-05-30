package com.example.openbanktechnicaltestsanabriaalejandro.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.openbanktechnicaltestsanabriaalejandro.R
import com.example.openbanktechnicaltestsanabriaalejandro.databinding.FragmentSuperHeroesListBinding
import com.example.openbanktechnicaltestsanabriaalejandro.view.RecyclerViewTools.SuperHeroesListAdapter
import com.example.openbanktechnicaltestsanabriaalejandro.viewmodel.SuperHeroesListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSuperHeroesList : Fragment(R.layout.fragment_super_heroes_list) {

    private val superHeroListViewModel: SuperHeroesListViewModel by activityViewModels()

    private lateinit var binding: FragmentSuperHeroesListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSuperHeroesListBinding.bind(view)

        superHeroListViewModel.onGetAllHeroes()

        superHeroListViewModel.loading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        superHeroListViewModel.listOfAllHeroes.observe(viewLifecycleOwner) {
            binding.rvForAllHeroes.adapter = SuperHeroesListAdapter(it!!)

        }

        superHeroListViewModel.showError.observe(viewLifecycleOwner) {
            binding.tvForError.isVisible = it
        }
    }
}
