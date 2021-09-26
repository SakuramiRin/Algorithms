package muke.week3.chap2

/**
 * 括号匹配
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
class BracketMatching {

    /**
     * 普通直观解法.
     */
    fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return false
        }

        val deque = ArrayDeque<Char>()
        try {
            for (char in s) {
                when (char) {
                    '(' -> deque.add(char)
                    '[' -> deque.add(char)
                    '{' -> deque.add(char)
                    ')' -> {
                        if (deque.removeLast() != '(') {
                            return false
                        }
                    }
                    '}' -> {
                        if (deque.removeLast() != '{') {
                            return false
                        }
                    }
                    ']' -> {
                        if (deque.removeLast() != '[') {
                            return false
                        }
                    }
                    else -> return false
                }
            }
        } catch (e: Exception) {
            return false
        }
        return deque.isEmpty()
    }
}

fun main() {
    val bracketMatching = BracketMatching()
    println(bracketMatching.isValid("]"))
}