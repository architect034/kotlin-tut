package mostcompetitive

import java.util.Stack

class MostCompetitive {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val ans: IntArray = IntArray(k)
        var stack: Stack<Int> = Stack()
        var rem = k
        for (i in nums.indices) {
            while (stack.isNotEmpty() && stack.peek() > nums[i] && stack.size + nums.size - i > k) {
                stack.pop()
            }
            stack.push(nums[i])
        }
        var index = 0
        stack.forEach {
            if (index == k) {
                return@forEach
            }
            ans[index++] = it
        }
        return ans
    }
}
