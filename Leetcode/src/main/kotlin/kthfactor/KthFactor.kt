package kthfactor
import kotlin.math.sqrt

class KthFactor {
    fun kthFactor(n: Int, k: Int): Int {
        val factors = findFactors(n)
        return if (k > factors.size) -1 else factors[k - 1]
    }

    private fun findFactors(n: Int): MutableList<Int> {
        val factorsList = mutableListOf<Int>()
        for (i in 1..(sqrt(n.toDouble())).toInt()) {
            if (n % i == 0) {
                factorsList.add(i)
                if (n / i != i) {
                    factorsList.add(n / i)
                }
            }
        }
        factorsList.sort()
        return factorsList
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    KthFactor().kthFactor(n, k)
}
