package minoperations

import kotlin.math.min

class MinOperations {
    fun minOperations(nums: IntArray, x: Int): Int {
        var ans = Int.MAX_VALUE
        val howMuchFromBack: HashMap<Int, Int> = HashMap()
        howMuchFromBack.computeIfAbsent(0) { 0 }
        var sum = 0
        for (index in nums.size - 1 downTo 0) {
            sum += nums[index]
            if (sum == x) {
                ans = min(ans, nums.size - index)
            }
            howMuchFromBack.computeIfAbsent(sum) {
                return@computeIfAbsent nums.size - index
            }
        }
        sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            val leftCount = i + 1
            if (howMuchFromBack.containsKey(x - sum) && (leftCount + howMuchFromBack[x - sum]!! <= nums.size)) {
                ans = min(ans, leftCount + howMuchFromBack[x - sum]!!)
            }
        }
        return if (ans == Int.MAX_VALUE) {
            -1
        } else
            ans
    }
}
