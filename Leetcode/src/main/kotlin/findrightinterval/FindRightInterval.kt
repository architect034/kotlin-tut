package findrightinterval

class FindRightInterval {
    private val intervals: MutableList<MutableList<Int>> = mutableListOf()
    class SortComparator : Comparator<MutableList<Int>> {
        override fun compare(o1: MutableList<Int>?, o2: MutableList<Int>?): Int {
            if (o1 == null || o2 == null) return 0
            return when {
                o1[0] < o2[0] -> -1
                o1[0] > o2[0] -> 1
                o1[1] < o2[1] -> -1
                o1[1] > o2[1] -> 1
                o1[2] < o2[2] -> -1
                else -> 1
            }
        }
    }
    lateinit var answer: IntArray
    fun findRightInterval(param: Array<IntArray>): IntArray {
        val n = param.size
        answer = IntArray(n) { -1 }
        val comparator = SortComparator()
        for (i in 0 until n) {
            intervals.add(
                param[i].map {
                    it
                }.toMutableList()
            )
            intervals[i].add(i)
        }
        intervals.sortWith(comparator)
        for (i in 0 until n) {
            var low = i; var high = n - 1; var ans: Int? = null
            while (low <= high) {
                val mid = (low + high).shr(1)
                if (intervals[mid][0] >= intervals[i][1]) {
                    ans = mid
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
            ans?.let {
                answer[intervals[i][2]] = intervals[ans][2]
            }
        }
        return answer
    }
}
