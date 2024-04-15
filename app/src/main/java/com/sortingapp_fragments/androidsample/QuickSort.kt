package com.sortingapp.androidsample

class QuickSort(private var arr: IntArray) {
    fun sort() {
        val start = 0
        val end = arr.size-1
        quickSort(start, end)
    }

    private fun quickSort(start: Int, end: Int) {
        if(start < end) {
            val i = partition(start, end)
            quickSort(start, i-1)
            quickSort(i+1, end)
        }
    }

    private fun partition(start: Int, end: Int): Int {
        val pivotIndex = pivotIndex(start, end)
        val pivot = arr[pivotIndex]
        swap(pivotIndex, end)
        var l: Int
        var r: Int
        do {
            l = (start until end).firstOrNull { arr[it] > pivot }?: end
            r = (end-1 downTo start).firstOrNull { arr[it] < pivot }?: start
            if (l < r)
                swap(l, r)
        } while (l < r)
        swap(l, end)
        return l
    }

    private fun swap(i1: Int, i2: Int) {
        val temp = arr[i1]
        arr[i1] = arr[i2]
        arr[i2] = temp
    }

    private fun pivotIndex(start: Int, end: Int): Int {
        return start + (end-start) / 2
    }

    fun getArray(): IntArray {
        return this.arr
    }
}