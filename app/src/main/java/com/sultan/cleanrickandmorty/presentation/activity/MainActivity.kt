package com.sultan.cleanrickandmorty.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sultan.cleanrickandmorty.R
import com.sultan.cleanrickandmorty.databinding.ActivityMainBinding
import com.sultan.cleanrickandmorty.presentation.adapter.CharacterAdapter
import com.sultan.cleanrickandmorty.util.UIState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), CharacterAdapter.OnClickListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel : MainViewModel by viewModel()

    private val adapter = CharacterAdapter(this)

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
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.characterState.collect { state ->
                    when (state) {
                        is UIState.Empty -> {

                        }
                        is UIState.Error -> {

                        }
                        is UIState.Loading -> {

                        }
                        is UIState.Success -> {
                            adapter.submitList(state.data.results)
                        }
                    }
                }
            }
        }
    }

    override fun onClick(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
    }


}