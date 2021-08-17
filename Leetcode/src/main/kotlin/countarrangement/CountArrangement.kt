package countarrangement

import java.util.Collections.swap

class CountArrangement {
    private var ans = 0
    private fun solve(arr: MutableList<Int>, index: Int) {
        if (index == arr.size) {
            ans++
        }
        for (i in index until arr.size) {
            swap(arr, i, index)
            if ((arr[index] % (index + 1) == 0) || ((index + 1) % arr[index] == 0)) {
                solve(arr, index + 1)
            }
            swap(arr, i, index)
        }
    }

    fun countArrangement(n: Int): Int {
        val arr: MutableList<Int> = MutableList(n) { index -> index + 1 }
        solve(arr, 0)
        return ans
    }
}

fun main() {
    CountArrangement().countArrangement(2)
}
