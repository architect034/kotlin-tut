package minimumdeviation

import java.lang.Integer.min
import java.util.SortedSet

class MinimumDeviation {
    fun minimumDeviation(nums: IntArray): Int {
        val set: SortedSet<Int> = sortedSetOf()
        for (num in nums) {
            if ((num and 1) == 1) {
                set.add(num.shl(1))
            } else {
                set.add(num)
            }
        }
        var ans = set.last() - set.first()
        while (set.isNotEmpty() && (set.last() and 1 == 0)) {
            val last = set.last()
            set.remove(set.last())
            set.add(last.shr(1))
            ans = min(ans, set.last() - set.first())
        }
        return ans
    }
}
