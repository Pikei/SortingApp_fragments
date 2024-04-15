package com.sortingapp_fragments.androidsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Result : Fragment() {
    private var methodName: String? = null
    private var array: IntArray? = null
    private var printExample = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            methodName = it.getString(ARG_PARAM1)
            array = it.getIntArray(ARG_PARAM2)
        } 
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)
        val methodTextView = view.findViewById<TextView>(R.id.method)
        val explainButton = view.findViewById<Button>(R.id.explain)
        methodTextView.text = methodName
        displaySortedArray(view)
        explainButton.setOnClickListener { explainButton(view) }
        return view
    }

    private fun displaySortedArray(view: View) {
        val sortedArrayTextView = view.findViewById<TextView>(R.id.sortedNumbers)
        var sortedArrayString = ""
        for(i in 0 until array!!.size) {
            sortedArrayString += if(i != array!!.size - 1)
                array!![i].toString() + ", "
            else
                array!![i].toString()
        }
        sortedArrayTextView.text = sortedArrayString
    }

    private fun explainButton(view: View) {
        val explanation = view.findViewById<TextView>(R.id.explanation)
        if (methodName == "Bubble Sort") {
            explainBubbleSort(explanation)
        } else if (methodName == "Quick Sort") {
            explainQuickSort(explanation)
        }
    }

    private fun explainBubbleSort(explanation: TextView) {
        val explanationMessage = """
            Bubble sort, is a simple sorting algorithm that 
            repeatedly steps through the input list element by element, 
            comparing the current element with the one after it, 
            swapping their values if needed. These passes through the list 
            are repeated until no swaps have to be performed during a pass, 
            meaning that the list has become fully sorted. 
            The algorithm, which is a comparison sort, is named 
            for the way the larger elements "bubble" up to the top of the list.
            Press button "Explain" again to see an example.
        """
        val exampleMessage = """
            Example:
            given array of unsorted numbers: 
                [6,2,4,5,3,1]
                
            1. Compare two numbers and swap them if needed:
                [6,2,4,5,3,1]
                 ^ ^
            2. Repeat comparing and swapping largest element 
            until it is at the end of array. Move border one element to the left
                [2,4,5,3,1|6]
                           ^
            3. Repeat steps to next largest number:
                [2,4,3,1|5,6]
                         ^
            4. Repeat steps 1-3 until array is sorted.

            """
        if (!printExample){
            explanation.text = explanationMessage
            explanation.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
            explanation.visibility = View.VISIBLE
            printExample = true
        } else {
            explanation.text = exampleMessage
            explanation.textAlignment = View.TEXT_ALIGNMENT_CENTER
            explanation.visibility = View.VISIBLE
            printExample = false
        }
    }

    private fun explainQuickSort(explanation: TextView) {
        val explanationMessage = """
            Quicksort works by selecting a 'pivot' element 
            from the array and partitioning the other elements 
            into two sub-arrays, according to whether they are 
            lesser than or greater than the pivot. 
            The sub-arrays are then sorted recursively.
            Press button "Explain" again to see an example.
        """
        val exampleMessage = """
            Example:
            given array of unsorted numbers: 
                [6,2,4,5,3,1]
                
            1. Select pivot and switch its position to end of array:
                [6,2,1,5,3,4]
                           ^
            2. Find first number from left that is greater than pivot 
            and first number from right that is lesser than pivot, and swap them:
                [3,2,1,5,6,4]
                 ^       ^
            3. Repeat until index from left is greater than or even 
            to index from right, then swap element of index from left with pivot:
                [3,2,1,4,6,5]
                       ^   ^
            4. Now everything to left is lesser than pivot, 
            and everything to right is greater than pivot.
            Repeat steps to sub-arrays:
                [3,2,1][6,5]
                
            5. Repeat steps 1-4 until array is sorted.
            """
        if (!printExample){
            explanation.text = explanationMessage
            explanation.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
            explanation.visibility = View.VISIBLE
            printExample = true
        } else {
            explanation.text = exampleMessage
            explanation.textAlignment = View.TEXT_ALIGNMENT_CENTER
            explanation.visibility = View.VISIBLE
            printExample = false
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: IntArray) =
            Result().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putIntArray(ARG_PARAM2, param2)
                }
            }
    }
}