package algorithms4

import createOrderedIntArray
import measureTime

class BinarySearch {
    fun rank(needSearch: Int, array: Array<Int>): Int {
        var leftIndex = 0
        var rightIndex = array.size - 1
        while (leftIndex <= rightIndex) {
            val midIndex = (leftIndex + rightIndex) / 2
            if (needSearch > array[midIndex]) {
                leftIndex = midIndex + 1
            } else if (needSearch < array[midIndex]) {
                rightIndex = midIndex - 1
            } else {
                return midIndex
            }
        }
        return -1
    }
}




fun main() {
    measureTime(1) {
        val needSearch = 10000000
        // val array = arrayListOf(1, 2, 3, 4, 6)
        val array = createOrderedIntArray(10000000)
        // array.map { println(it) }
        val binarySearch = BinarySearch()
        val result = binarySearch.rank(needSearch, array)
        if (result == -1) {
            println("not have")
        } else {
            println("index $result")
        }
    }
}
