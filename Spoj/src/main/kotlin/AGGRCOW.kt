class AGGRCOW(
    var cows: Int,
    var stallsPos: MutableList<Int>
) {
    private fun isPossibleDistance(distance: Int): Boolean {
        var lastCowAt = stallsPos.first()
        var cowsPlaced = 1
        for (pos in stallsPos) {
            if (pos - lastCowAt >= distance) {
                lastCowAt = pos
                cowsPlaced++
            }
        }
        if (cowsPlaced >= cows) {
            return true
        }
        return false
    }
    fun aggrcow(): Int {
        var low = 0
        var answer = 0
        var high = stallsPos.last() - stallsPos.first()
        while (low <= high) {
            val mid = (low + high) / 2
            if (isPossibleDistance(distance = mid)) {
                answer = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return answer
    }
}

fun main() {
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        val input = readLine()!!.split(" ").map { return@map it.toInt() }
        val stalls = input[0]
        val cows = input[1]
        val stallsPos = MutableList(stalls) { 0 }
        for (index in 0 until stalls) {
            stallsPos[index] = readLine()!!.toInt()
        }
        stallsPos.sort()
        println(AGGRCOW(cows, stallsPos).aggrcow())
    }
}
