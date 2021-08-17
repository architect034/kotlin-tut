package findmin

class FindMin {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var low = 0; var high = nums.size - 1
        while (low <= high) {
            val mid = (low + high).shr(1)
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid]
            }
            if (mid + 1 < nums.size && nums[mid + 1] < nums[mid]) {
                return nums[mid + 1]
            }
            if (nums[mid] < nums[0]) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return nums[0]
    }
}
