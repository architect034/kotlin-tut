package minsubarraylen

class MinSubArrayLen {
    lateinit var arr: MutableList<Int>
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var segmentLen = nums.size - 1; arr = nums.toMutableList()
        var low = 1; var high = nums.size
        while (low <= high) {
            val mid = (low + high).shr(1)
            if (isThisLengthPossible(mid, target)) {
                segmentLen = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return segmentLen
    }

    private fun isThisLengthPossible(length: Int, target: Int): Boolean {
        val segment = arr.filterIndexed { index, _ -> index < length }.toMutableList()
        var sum = segment.sum()
        if (sum >= target) return true
        for ((frontIndex, i) in (length until arr.size).withIndex()) {
            segment.add(arr[i])
            sum += segment.last()
            sum -= segment[frontIndex]
            if (sum >= target) return true
        }
        return false
    }
}
