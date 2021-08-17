package findlength

import kotlin.math.max

class FindLength {
    fun findLength(arr1: IntArray, arr2: IntArray): Int {
        val dp = Array(arr1.size + 1) { IntArray(arr2.size + 1) { 0 } }
        for (i in arr1.size - 1 downTo 0) {
            for (j in arr2.size - 1 downTo 0) {
                if (arr1[i] == arr2[j]) { dp[i][j] = dp[i + 1][j + 1] + 1 }
            }
        }
        return dp.reduce { prevRow, currRow ->
            prevRow.mapIndexed { index, value ->
                max(value, currRow[index])
            }.toIntArray()
        }.reduce { runningMax, value ->
            max(runningMax, value)
        }
    }
}
