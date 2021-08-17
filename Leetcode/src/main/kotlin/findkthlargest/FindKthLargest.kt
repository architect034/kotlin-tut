package findkthlargest

import java.util.PriorityQueue

class FindKthLargest {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq: PriorityQueue<Int> = PriorityQueue()
        for (num in nums) {
            pq.add(num)
            if (pq.size > k) {
                pq.poll()
            }
        }
        return pq.poll()
    }
}
