class Remainder {
    private fun Char.toInteger(): Int {
        return this.toString().toInt()
    }
    fun remainder(dividend: String, divisor: Int): Int {
        if (dividend.length <= 2) {
            return dividend.toInt() % divisor
        }
        var answer = (dividend[0].toInteger() * 10 + dividend[1].toInteger()) % divisor
        for (i in 2 until dividend.length) {
            answer = (answer * 10 + dividend[i].toInteger()) % divisor
        }
        return answer
    }
}

fun main() {
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        val input = readLine()!!.split(" ").map {
            return@map it
        }
        val remainder = Remainder().remainder(input[0], input[1].toInt())
        println(remainder)
    }
}
