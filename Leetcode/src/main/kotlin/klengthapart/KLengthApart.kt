package klengthapart

class KLengthApart {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var lastIndex = -2 * nums.lastIndex
        for (index in nums.indices) {
            if (nums[index] == 1) {
                if (index - lastIndex - 1 < k)
                    return false
                lastIndex = index
            }
        }
        return true
    }
}
