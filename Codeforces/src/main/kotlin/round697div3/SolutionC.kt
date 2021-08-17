package round697div3

class SolutionC(
    private val a: Int,
    private val b: Int,
    private val k: Int
) {
    fun solve(boys: MutableList<Int>, girls: MutableList<Int>): Long {
        var totalPairs = 0L
        val boysHash = Array(a + 1) { 0 }
        val girlsHash = Array(b + 1) { 0 }
        for (boy in boys) {
            boysHash[boy]++
        }
        for (girl in girls) {
            girlsHash[girl]++
        }
        for (pairNo in 0 until k) {
            val boyNo = boys[pairNo]
            val girlNo = girls[pairNo]
            totalPairs += (k.toLong() - boysHash[boyNo] - girlsHash[girlNo] + 1)
        }
        return totalPairs / 2
    }
}

fun main() {
    var testCases = readLine()!!.toInt()
    while (testCases-- > 0) {
        var input = readLine()!!.split(" ").map {
            return@map it.toInt()
        }
        val boys = readLine()!!.split(" ").map {
            return@map it.toInt()
        } as MutableList<Int>
        val girls = readLine()!!.split(" ").map {
            return@map it.toInt()
        } as MutableList<Int>
        val answer = SolutionC(input[0], input[1], input[2]).solve(boys, girls)
        println(answer)
    }
}
