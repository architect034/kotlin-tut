class WhoIsHappy {
    fun whoIsHappy() {
        val input = readLine()!!.split(" ").map {
            if (it[0] in '0'..'9') {
                return@map it.toInt()
            } else {
                return@map it
            }
        }
        val str: String = input[1] as String
        var countA = 0
        var countB = 0
        for (ch in str) {
            if (ch == 'A') countA++
            if (ch == 'B') countB++
        }
        when {
            countA > countB -> println("Anirban")
            countA < countB -> println("Biswa")
            else -> println("Samay")
        }
    }
}

fun main() {
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        WhoIsHappy().whoIsHappy()
    }
}
