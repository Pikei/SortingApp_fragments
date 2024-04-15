package com.sortingapp_fragments.androidsample

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sortingapp.androidsample.BubbleSort
import com.sortingapp.androidsample.QuickSort
import com.sortingapp_fragments.androidsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val resultButton = binding.result
        val dataInputButton = binding.data
        resultButton.setOnClickListener {
            val nums: String = findViewById<EditText>(R.id.numbers).text.toString()
            if ( nums != "") {
                val quickSortRadioButton = findViewById<RadioButton>(R.id.quickSortRadioBtn)
                val bubbleSortRadioButton = findViewById<RadioButton>(R.id.bubbleSortRadioBtn)
                if ( bubbleSortRadioButton.isChecked) {
                    val bubbleSort = BubbleSort(getNumbers())
                    bubbleSort.bubbleSort()
                    val result = Result.newInstance("Bubble Sort", bubbleSort.getArray())
                    replaceFragment(result)
                } else if (quickSortRadioButton.isChecked) {
                    val quickSort = QuickSort(getNumbers())
                    quickSort.sort()
                    val result = Result.newInstance("Quick Sort", quickSort.getArray())
                    replaceFragment(result)
                }
            }
        }
        dataInputButton.setOnClickListener {
            replaceFragment(UserInput())
        }

    }

    private fun  getNumbers(): IntArray {
        var numbers = findViewById<EditText>(R.id.numbers).text.toString()
        numbers = numbers.replace(" ", ",")
        numbers = numbers.replace(",,", ",")
        val stringBuilder = StringBuilder(numbers)
        if (numbers[0] == ',') {
            numbers = stringBuilder.deleteAt(0).toString()
        }
        if (numbers[numbers.length-1] == ',') {
            numbers = stringBuilder.deleteAt(numbers.length-1).toString()
        }
        return numbers.split(",").map { it.toInt() }.toIntArray()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment).setReorderingAllowed(true)
        fragmentTransaction.commit()
    }


}