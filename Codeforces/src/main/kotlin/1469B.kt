import kotlin.math.max

class Solution1469B {
    fun readAndBlue(red: MutableList<Int>, blue: MutableList<Int>): Int {
        for (i in 1 until red.size) {
            red[i] += red[i - 1]
        }
        for (i in 1 until blue.size) {
            blue[i] += blue[i - 1]
        }
        var answer = max(red.maxOrNull()!!, blue.maxOrNull()!!)
        answer = max(answer, red.maxOrNull()!! + blue.maxOrNull()!!)
        return max(answer, 0)
    }
}

fun main() {
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        val redCount = readLine()!!.toInt()
        var red = readLine()!!.split(" ").map {
            return@map it.toInt()
        } as MutableList<Int>
        val blueCount = readLine()!!.toInt()
        var blue = readLine()!!.split(" ").map {
            return@map it.toInt()
        } as MutableList<Int>
        println(Solution1469B().readAndBlue(red, blue))
    }
}
