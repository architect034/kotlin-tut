import kotlin.math.sqrt

const val MAX = 1000001

class Sieve {
    companion object {
        var primes = Array(MAX) { 1 }
        fun sieve() {
            primes[0] = 0
            primes[1] = 0
            for (i in 4L until MAX step 2) {
                primes[i.toInt()] = 0
            }
            for (i in 3L until MAX step 2) {
                if (primes[i.toInt()] == 1) {
                    for (j in i * i until MAX step i) {
                        primes[j.toInt()] = 0
                    }
                }
            }
            for (i in 1 until MAX) {
                primes[i] += primes[i - 1]
            }
        }
    }
}
class TriPrime {
    fun triPrime(n: Long): Int {
        val sqrtN = sqrt(n.toDouble()).toInt()
        return Sieve.primes[sqrtN]
    }
}

fun main() {
    Sieve.sieve()
    val testCases = readLine()!!.toInt()
    for (i in 0 until testCases) {
        val n = readLine()!!.toLong()
        val noOfTriPrimes = TriPrime().triPrime(n)
        println(noOfTriPrimes)
    }
}
