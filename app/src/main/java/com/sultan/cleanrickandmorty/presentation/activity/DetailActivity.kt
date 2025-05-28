package com.sultan.cleanrickandmorty.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.sultan.cleanrickandmorty.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private val viewModel : DetailViewModel by viewModel()
    private val id by lazy { intent.getIntExtra("ID", 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getCharacterById(id)
        initialize()
    }

    private fun initialize() {
        initializeObserver()
    }

    private fun initializeObserver() {
        viewModel.result.observe(this) { data ->
            binding.name.text = data.name
            Glide.with(binding.image.context)
                .load(data.image)
                .centerCrop()
                .placeholder(android.R.color.darker_gray)
                .into(binding.image)
        }
    }
}