package muke.week2.chap2

import createOrderedIntArray
import measureTime
import muke.week2.chap1.SelectSort
import kotlin.random.Random

/**
 * 插入排序.
 */
class InsertSort private constructor() {

    companion object {
        /**
         * 通过交换值（优化前）.
         */
        fun <T : Comparable<T>> insertSortWithTemp(array: Array<T>): Array<T> {
            outer@ for (index in 1 until array.size) {
                inner@ for (innerIndex in index downTo 1) {
                    if (array[innerIndex] < array[innerIndex - 1]) {
                        val temp = array[innerIndex]
                        array[innerIndex] = array[innerIndex - 1]
                        array[innerIndex - 1] = temp
                    } else {
                        continue@outer
                    }
                }
            }
            return array
        }

        /**
         * 不频繁交换，而是赋值挪动（优化后）
         */
        fun <T : Comparable<T>> insertSortWithOptimization(array: Array<T>): Array<T> {
            outer@ for (index in 1 until array.size) {
                val tempValue = array[index]
                var needInsertIndex: Int
                inner@ for (innerIndex in index downTo 1) {
                    if (tempValue < array[innerIndex - 1]) {
                        array[innerIndex] = array[innerIndex - 1]
                        needInsertIndex = innerIndex
                    } else {
                        break@inner
                    }
                    array[needInsertIndex - 1] = tempValue
                }
            }
            return array
        }
    }
}

fun main() {
    measureTime(1) {
        val intArray = Array(10) {
            Random.nextInt(1000)
        }.onEach { print("$it ") }
        println()
        InsertSort.insertSortWithTemp(intArray).forEach {
            print("$it ")
        }
    }
    measureTime(1) {
        val intArray = Array(10) {
            Random.nextInt(1000)
        }.onEach { print("$it ") }
        println()
        InsertSort.insertSortWithOptimization(intArray).forEach {
            print("$it ")
        }
    }

    // 优化前后比较.

    val intArray = Array(10000) {
        Random.nextInt(1000)
    }
    // 不进行copyOf的话，后一次处理的数组实际为已经排好序的数组.
    val intArrayCopy = intArray.copyOf()
    // 所耗时间: 16700 ms
    measureTime(1) {
        println()
        InsertSort.insertSortWithTemp(intArray)
    }
    // 所耗时间: 13328 ms
    measureTime(1) {
        println()
        InsertSort.insertSortWithOptimization(intArrayCopy)
    }


    // 对于有序数组，选择排序和插入排序的比较
    val intOrderedArray = createOrderedIntArray(100000)
    // 所耗时间: 6782 ms
    measureTime(1) {
        println()
        SelectSort.sort(intOrderedArray)
    }
    // 所耗时间: 1 ms
    measureTime(1) {
        println()
        InsertSort.insertSortWithOptimization(intOrderedArray)
    }

}