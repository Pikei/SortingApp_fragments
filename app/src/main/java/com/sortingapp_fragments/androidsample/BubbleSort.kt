package com.sortingapp.androidsample

class BubbleSort(private var arr: IntArray) {
    fun bubbleSort() {
        val arrSize = arr.size
        for (i in 0 until arrSize - 1) {
            for (j in 0 until arrSize - i -1) {
                if (arr[j] > arr[j+1]) {
                    val temp = arr[j]
                    arr[j] = arr[j+1]
                    arr[j+1] = temp
                }
            }
        }
    }

    fun getArray(): IntArray {
        return this.arr
    }
}