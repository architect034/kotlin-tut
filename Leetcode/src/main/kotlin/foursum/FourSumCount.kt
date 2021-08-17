package foursum
class FourSumCount {
    fun fourSumCount(A: MutableList<Int>, B: MutableList<Int>, C: MutableList<Int>, D: MutableList<Int>): Int {
        var count = 0

        val sumOfAandB = mutableListOf<Int>()
        for (i in A) {
            for (j in B) {
                sumOfAandB.add(i + j)
            }
        }
        val countOfSums = HashMap<Int, Int>()
        for (i in C) {
            for (j in D) {
                countOfSums[i + j] = countOfSums.getOrDefault(i + j, 0) + 1
            }
        }
        for (i in sumOfAandB) {
            val isPresent = -i
            count += countOfSums.getOrDefault(isPresent, 0)
        }
        return count
    }
}

fun main() {
    val A = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as MutableList<Int>
    val B = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as MutableList<Int>

    val C = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as MutableList<Int>
    val D = readLine()!!.split(" ").map {
        return@map it.toInt()
    } as MutableList<Int>
    println(FourSumCount().fourSumCount(A, B, C, D))
}
