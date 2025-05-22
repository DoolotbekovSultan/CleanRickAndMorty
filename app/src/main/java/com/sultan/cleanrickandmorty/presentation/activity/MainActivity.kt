package com.sultan.cleanrickandmorty.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sultan.cleanrickandmorty.R
import com.sultan.cleanrickandmorty.databinding.ActivityMainBinding
import com.sultan.cleanrickandmorty.presentation.adapter.CharacterAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel : MainViewModel by viewModel()
    private val adapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getCharacter()
        initialize()
    }

    private fun initialize() {
        initializeAdapter()
        initializeObserver()
    }

    private fun initializeAdapter() {
        binding.characterRecyclerView.adapter = adapter
    }

    private fun initializeObserver() {
        viewModel.character.observe(this) { characterResponse ->
            Log.e("ololo", "initializeObserver: $characterResponse" )
            adapter.submitList(characterResponse?.results)
        }
    }

}