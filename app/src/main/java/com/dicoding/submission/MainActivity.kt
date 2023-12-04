package com.dicoding.submission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.submission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private val list = ArrayList<Food>()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvFood = binding.rvFood
        rvFood.setHasFixedSize(true)

        list.addAll(getListFood())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_About -> {
                val intent = Intent(this,about::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFood(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataDescription2 = resources.getStringArray(R.array.data_description_pembuatan)
        val listFood = ArrayList<Food>()
        for (i in dataName.indices) {
            val food = Food(dataName[i], dataDescription[i], dataPhoto[i], dataDescription2[i])
            listFood.add(food)
        }
        return listFood
    }

    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedFood(data)
            }
        })
    }

    private fun showSelectedFood(food: Food) {
        Toast.makeText(this, "Kamu memilih " + food.name, Toast.LENGTH_SHORT).show()
    }
}