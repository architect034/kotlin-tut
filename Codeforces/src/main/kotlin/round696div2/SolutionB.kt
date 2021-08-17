package round696div2

object Sieve {
    var prime: MutableList<Int> = mutableListOf()
    var isPrime: Array<Boolean> = Array(100001) { index -> index != 1 }
    fun calculate() {
        prime.add(1)
        prime.add(2)
        for (index in 4..isPrime.lastIndex step 2) {
            isPrime[index] = false
        }
        for (primeNumber in 3L..isPrime.lastIndex step 2) {
            if (isPrime[primeNumber.toInt()]) {
                prime.add(primeNumber.toInt())
                for (multiples in primeNumber * primeNumber..isPrime.lastIndex step primeNumber) {
                    isPrime[multiples.toInt()] = false
                }
            }
        }
    }
}

class SolutionB {
    fun solve(difference: Int): Int {
        var answer = 1
        var last = 1
        var kitnaDone = 1
        for (prime in Sieve.prime) {
            if (prime - last >= difference) {
                answer *= prime
                last = prime
                kitnaDone++
                if (kitnaDone == 3) {
                    break
                }
            }
        }
        return answer
    }
}

fun main() {
    var testCases = readLine()!!.toInt()
    Sieve.calculate()
    while (testCases-- > 0) {
        val n = readLine()!!.toInt()
        val ans = SolutionB().solve(n)
        println(ans)
    }
}
