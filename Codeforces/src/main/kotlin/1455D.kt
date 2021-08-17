class Solution1455D {
    fun solve() {
        val input = readLine()!!.split(" ").map {
            return@map it.toInt()
        }
        val n = input[0]
        var x = input[1]
        val arr = readLine()!!.split(" ").map {
            return@map it.toInt()
        }.toMutableList()
        var st = 0
        var moves = 0
        while (true) {
            var done = false
            for (i in st until n - 1) {
                if (arr[i] > arr[i + 1]) {
                    for (j in 0..i) {
                        if (arr[j] > x) {
                            val temp = arr[j]
                            arr[j] = x
                            x = temp
                            st = j
                            done = true
                            moves++
                            break
                        }
                    }
                }
                if (done) {
                    break
                }
            }
            if (!done) {
                break
            }
        }
        if (!arr.isSorted()) {
            println(-1)
            return
        }
        println(moves)
    }
    private fun MutableList<Int>.isSorted(): Boolean {
        val x = map {
            return@map it
        }
        for (i in 0 until x.size - 1) {
            if (x[i] > x[i + 1]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val tc = readLine()!!.toInt()
    for (i in 0 until tc) {
        Solution1455D().solve()
    }
}
