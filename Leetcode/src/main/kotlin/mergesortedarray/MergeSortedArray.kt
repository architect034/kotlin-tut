package mergesortedarray

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        if (nums2.isEmpty()) return
        var start = nums1.size
        for (index in nums1.size - 1 downTo 0) {
            if (index == m - 1) {
                var newIndex = index
                var lastIndex = nums1.lastIndex
                while (newIndex >= 0) {
                    nums1[lastIndex--] = nums1[newIndex--]
                    start = lastIndex + 1
                }
                break
            }
        }
        var index1 = start
        var index2 = 0
        var index = 0
        while (index1 < nums1.size && index2 < nums2.size) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index++] = nums1[index1++]
            } else {
                nums1[index++] = nums2[index2++]
            }
        }
        while (index1 < nums1.size) {
            nums1[index++] = nums1[index1++]
        }
        while (index2 < nums2.size) {
            nums1[index++] = nums2[index2++]
        }
    }
}
