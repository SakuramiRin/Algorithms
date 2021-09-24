package muke.week2.chap1

import createRandomIntArray
import measureTime

/**
 * 选择排序.
 */
class SelectSort private constructor() {
    companion object {
        fun <T : Comparable<T>> sort(array: Array<T>): Array<T> {
            for (index in 0..array.size - 2) {
                var minValueIndex = index
                for (minIndex in index until array.size) {
                    // Kotlin 的 > 使用了操作符重载，所以不必使用compareTo
                    if (array[minValueIndex] > array[minIndex]) {
                        minValueIndex = minIndex
                    }
                }
                if (minValueIndex != index) {
                    val temp = array[index]
                    array[index] = array[minValueIndex]
                    array[minValueIndex] = temp
                }
            }
            return array
        }
    }
}

fun main() {
    measureTime(1) {
        val array = createRandomIntArray(10, 100)
        println()
        val sortedArray = SelectSort.sort(array)
        sortedArray.forEach (::println)
    }
}