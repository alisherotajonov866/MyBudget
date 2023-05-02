package ru.startandroid.mybudget

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ru.startandroid.mybudget.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        /*val navController = findNavController(R.id.fragmentContainerView)
        val config = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController,config)*/


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_add) {
            findNavController(R.id.fragmentContainerView).navigate(R.id.insertFragment)
            true
        } else super.onOptionsItemSelected(item)
    }


}