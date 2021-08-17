package numberofsteps

import kotlin.math.log

class NumberOfSteps {
    fun numberOfSteps(num: Int): Int {
        if (num == 0) return num
        val totalBits = log(num.toFloat(), 2f).toInt() + 1
        print(totalBits)
        val setBits = findSetBits(num)
        return totalBits + setBits - 1
    }

    private fun findSetBits(num: Int): Int {
        var n = num; var count = 0
        while (n > 0) {
            n = (n and (n - 1))
            count++
        }
        return count
    }
}
fun main() {
    NumberOfSteps().numberOfSteps(0)
}
