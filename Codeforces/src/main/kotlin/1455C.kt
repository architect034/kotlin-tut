class Solve1455C {
    fun solve() {
        val stamina = readLine()!!.split(" ").map {
            return@map it.toInt()
        }
        println("${stamina[0] - 1} ${stamina[1]}")
    }
}

fun main() {
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        Solve1455C().solve()
    }
}
