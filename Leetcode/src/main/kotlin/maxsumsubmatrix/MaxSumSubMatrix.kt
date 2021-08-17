package maxsumsubmatrix

import java.lang.Integer.max
import java.util.TreeSet

class MaxSumSubMatrix {
    private fun maxSubArraySumInArrayLessThanK(arr: IntArray, k: Int): Int {
        val prefixSums: TreeSet<Int> = TreeSet()
        prefixSums.add(0)
        var sum = 0
        var maxSubArraySum = Int.MIN_VALUE
        for (num in arr) {
            sum += num
            prefixSums.ceiling(sum - k)?.let {
                maxSubArraySum = max(maxSubArraySum, sum - it)
            }
            prefixSums.add(sum)
        }
        return maxSubArraySum
    }
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        var ans = Int.MIN_VALUE
        val n = matrix[0].size
        for (i in matrix.indices) {
            val arr = IntArray(n) { 0 }
            for (j in i..matrix.lastIndex) {
                for (index in arr.indices) {
                    arr[index] += matrix[j][index]
                }
                ans = max(ans, maxSubArraySumInArrayLessThanK(arr, k))
            }
        }
        return ans
    }
}
