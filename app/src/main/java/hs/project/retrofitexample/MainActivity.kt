package hs.project.retrofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import hs.project.retrofitexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activity = this

    }

    fun btnImgSearchClickAction() {
        startActivity(Intent(this@MainActivity, ImageSearchActivity::class.java))
    }

    fun btnUserSearchClickAction() {
        startActivity(Intent(this@MainActivity, UserSearchActivity::class.java))
    }
}