package countvowelpermutations

internal class CountVowelPermutations {
    private lateinit var memo: Array<LongArray>
    private val mod = 1000000007
    fun countVowelPermutation(n: Int): Int {
        // each row stands for the length of string
        // each column indicates the vowels
        // specifically, a: 0, e: 1, i: 2, o: 3, u: 4
        memo = Array(n) { LongArray(5) }
        var result: Long = 0
        for (i in 0..4) {
            result = (result + vowelPermutationCount(n - 1, i)) % mod
        }
        return result.toInt()
    }

    fun vowelPermutationCount(i: Int, vowel: Int): Long {
        if (memo[i][vowel] != 0L) return memo[i][vowel]
        if (i == 0) {
            memo[i][vowel] = 1
        } else {
            when (vowel) {
                0 -> {
                    memo[i][vowel] =
                        (
                        vowelPermutationCount(i - 1, 1) + vowelPermutationCount(i - 1, 2) + vowelPermutationCount(
                            i - 1,
                            4
                        )
                        ) % mod
                }
                1 -> {
                    memo[i][vowel] = (vowelPermutationCount(i - 1, 0) + vowelPermutationCount(i - 1, 2)) % mod
                }
                2 -> {
                    memo[i][vowel] = (vowelPermutationCount(i - 1, 1) + vowelPermutationCount(i - 1, 3)) % mod
                }
                3 -> {
                    memo[i][vowel] = vowelPermutationCount(i - 1, 2)
                }
                4 -> {
                    memo[i][vowel] = (vowelPermutationCount(i - 1, 2) + vowelPermutationCount(i - 1, 3)) % mod
                }
            }
        }
        return memo[i][vowel]
    }
}
