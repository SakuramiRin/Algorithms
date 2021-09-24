package algorithms4

class Practice {

    fun practice111() {
        println((0 + 15) / 2)
        // 2.0e-6 => 2.0 * 10^-6
        println(2.0e-6 * 100000000.1)
        println(true && false || true && true)
    }

    fun practice112() {
        println((1 + 2.236) / 2)
        println(1 + 2 + 3 + 4.0)
        println(4.1 >= 4.0)
        //  kotlin中不允许出现int + 字符串.
        //  java中 println(1 + 2 + "3") => 33
    }

}

fun main() {
    val practice = Practice()
    practice.practice111();
    practice.practice112();
}