import kotlin.math.abs

class Solution1469A {
    fun isRegularBracketSequence(seq: String): String {
        if (seq.length % 2 == 1) {
            return "NO"
        }
        var count = 0
        var extra = 0
        var isOpen = false
        for (ch in seq) {
            if (ch == '(') {
                isOpen = true
                count++
            } else if (ch == ')') {
                count--
                isOpen = false
                if (count < 0) {
                    val mg = abs(count)
                    if (mg > extra) return "NO"
                }
            } else {
                extra++
                isOpen = false
            }
        }
        return if (isOpen) "NO"
        else "YES"
    }
}
fun main() {
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        val seq = readLine()!!
        println(Solution1469A().isRegularBracketSequence(seq))
    }
}
