package muke.week3.chap2

import muke.week3.chap1.Array

class ArrayStack<T>(capacity: Int = 10) : Stack<T> {

    private val array = Array<T>(capacity)

    override fun push(t: T) = array.addLast(t)

    override fun pop(): T {
        val element = array.find(array.size - 1)
        array.deleteElement(array.size - 1)
        return element
    }

    override fun peek() = array.find(array.size - 1)

    override fun getSize() = array.size

    override fun isEmpty() = array.size == 0

    fun getCapacity() = array.capacity

    override fun toString(): String {
        return "ArrayStack(array=$array)"
    }

}

interface Stack<T> {
    fun push(t: T)
    fun pop(): T
    fun peek(): T
    fun getSize(): Int
    fun isEmpty(): Boolean
}

fun main() {
    val array = ArrayStack<Int>()
    array.push(0)
    array.push(1)
    array.push(2)
    array.push(3)
    array.push(4)
    array.push(5)
    array.push(6)
    array.push(7)
    array.push(8)
    array.push(9)
    println(array.toString())
    array.push(10)
    println(array.toString())
    println(array.pop())
    println(array.toString())

}