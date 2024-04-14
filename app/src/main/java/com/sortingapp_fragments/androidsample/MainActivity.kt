package com.sortingapp_fragments.androidsample

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.sortingapp_fragments.androidsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val resultButton = binding.result
        resultButton.setOnClickListener {
            val nums: String = findViewById<EditText>(R.id.numbers).text.toString()
            if ( nums != "") {
                replaceFragment(Result())
            }
        }
        val dataInputButton = binding.data
        dataInputButton.setOnClickListener {
            replaceFragment(UserInput())
        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment).setReorderingAllowed(true)
        fragmentTransaction.commit()
    }
}