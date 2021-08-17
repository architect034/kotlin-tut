class BadDays {
    fun countBadDays(days: List<Int>): Int {
        if (days.size <= 2) return 0
        var answer = 0
        var firstMax = days[0]
        var secondMax = days[1]
        if (days[1] > firstMax) {
            firstMax = days[1]
            secondMax = days[0]
        }
        for (index in 2 until days.size) {
            if (days[index] < firstMax && days[index] < secondMax) {
                answer++
            }
            val values = mutableListOf(days[index], firstMax, secondMax)
            values.sort()
            firstMax = values[2]
            secondMax = values[1]
        }
        return answer
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val days = readLine()!!.split(" ").map {
        return@map it.toInt()
    }
    println(BadDays().countBadDays(days))
}
