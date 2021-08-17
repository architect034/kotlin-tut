package longestones

import java.lang.Integer.max

class LongestOnes {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var st = 0
        var end = -1
        var zerosFlipped = 0
        var ans = 0
        while (end < nums.size) {
            if (zerosFlipped > k) {
                while (st <= end && zerosFlipped > k) {
                    zerosFlipped -= ((nums[st] + 1) % 2)
                    st++
                }
            } else {
                end++
                if (end >= nums.size) break
                zerosFlipped += ((nums[end] + 1) % 2)
                if (zerosFlipped <= k)
                    ans = max(ans, end - st + 1)
            }
        }
        return ans
    }
}
