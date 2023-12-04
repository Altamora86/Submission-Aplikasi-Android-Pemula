@file:Suppress("DEPRECATION")

package com.dicoding.submission

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dicoding.submission.databinding.ActivityDetailItemBinding

class DetailItem : AppCompatActivity() {
    private lateinit var binding: ActivityDetailItemBinding

    companion object {
        const val SET = "set"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tujuan = intent.getParcelableExtra<Food>(SET)

        if (tujuan != null) {
            Log.i("TES", tujuan.toString())
            binding.tvName.text = tujuan.name
            binding.tvDescription.text = tujuan.description
            Glide.with(this)
                .load(tujuan.photo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.imgPhoto)
            binding.tvDescription2.text = tujuan.description2

        }
    }
}
