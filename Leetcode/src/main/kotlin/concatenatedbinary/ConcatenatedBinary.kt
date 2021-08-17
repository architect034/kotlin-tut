package concatenatedbinary
const val MOD = 1000000007

class ConcatenatedBinary {
    fun concatenatedBinary(n: Int): Int {
        var answer = 0L
        var length = 0
        for (i in 1..n) {
            if ((i and (i - 1)) == 0) {
                length++
            }
            answer = (answer.shl(length)) % MOD
            answer += i
            answer %= MOD
        }
        return answer.toInt()
    }
}

fun main() {
    val ans = ConcatenatedBinary().concatenatedBinary(1)
    println(ans)
}
