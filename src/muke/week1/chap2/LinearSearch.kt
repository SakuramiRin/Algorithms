package muke.week1.chap2

fun main() {
    val data = arrayOf(24, 18, 12, 9, 16, 66, 32, 4)
    val target = 16
    val search = LinearSearch.search<Int>(data, target)
    println(search)
}

/**
 * 线性搜索.
 */
class LinearSearch private constructor(){


    companion object {
        /**
         * 线性搜索.
         *
         * @param data   目标数组
         * @param target 目标元素
         * @param <T>    目标类型
         * @return 索引值
        </T> */
        fun <T> search(data: Array<T>, target: T): Int {
            for (i in data.indices) {
                // 坑点 java用泛型后不能用==，因为比较的是两个内存地址.
                // if (data[i] == target) {
                // 而Kotlin中==为equals,===为内存地址比较
                if (data[i] == target) {
                    return i
                }
            }
            return -1
        }
    }


    /**
     * 对象相等概念加深.
     */
    private inner class Student(val name: String) {

        override fun equals(other: Any?): Boolean {
            // 判空必须要有！.
            if (other == null) {
                return false
            }

            // 地址相同的情况下应该提前返回真！.
            if (this === other) {
                return true
            }
            return if (other is LinearSearch.Student) {
                name == other.name
            } else {
                false
            }
        }

        // IDE 提示：覆盖toString方法同时，也应当覆盖hashCode方法.
        override fun hashCode(): Int {
            return name.hashCode()
        }
    }
}