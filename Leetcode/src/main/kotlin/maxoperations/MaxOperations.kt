package maxoperations

class MaxOperations {
    fun maxOperations(nums: IntArray, k: Int): Int {
        var pairs = 0
        nums.sort()
        var startIndex = 0
        var endIndex = nums.lastIndex
        while (startIndex < endIndex) {
            when {
                nums[startIndex] + nums[endIndex] == k -> {
                    pairs++
                    startIndex++
                    endIndex--
                }
                nums[startIndex] + nums[endIndex] > k -> {
                    endIndex--
                }
                else -> {
                    startIndex++
                }
            }
        }
        return pairs
    }
}
