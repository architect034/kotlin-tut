
import kotlin.math.sqrt

class DIVSUM {
    fun divSum(dividend: Long): Long {
        var answer = 0L
        for (divisor in 1..(sqrt(dividend.toDouble())).toLong()) {
            if (divisor >= dividend) {
                continue
            }
            if (dividend % divisor == 0L) {
                answer += divisor
                if (dividend / divisor != divisor && dividend / divisor < dividend) {
                    answer += (dividend / divisor)
                }
            }
        }
        return answer
    }
}

fun main() {
    var testCases = readLine()!!.toInt()
    while (testCases-- > 0) {
        val sum = DIVSUM().divSum(readLine()!!.toLong())
        println(sum)
    }
}
