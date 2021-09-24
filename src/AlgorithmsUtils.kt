import kotlin.random.Random

/**
 * 生成已排序Int数组.
 */
fun createOrderedIntArray(size: Int) = Array(size) { it + 1 }

/**
 * 生成随机Int数组
 */
fun createRandomIntArray(size: Int, until: Int) = Array(size) {
    // 两种生成随机数的方法.
    // (Math.random() * 100).toInt()
    Random.nextInt(until).also {
        if (size < 10) {
            print("$it ")
        }
    }
}
/**
 * 时间性能测试.
 */
fun measureTime(times: Int, block: () -> Unit) {
    val startTime = System.currentTimeMillis()
    for (i in 1..times) {
        block.invoke()
    }
    println("所耗时间: ${System.currentTimeMillis() - startTime} ms")
}

