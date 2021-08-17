package interval

import kotlin.math.max

class CustomComparator : Comparator<IntArray> {
    override fun compare(interval1: IntArray?, interval2: IntArray?): Int {
        return if (interval1?.get(0)!! < interval2?.get(0)!!) -1
        else if (interval1[0] > interval2[0]) 1
        else {
            if (interval1[1] < interval2[1]) -1
            else 1
        }
    }
}

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val mutableIntervals = intervals.toMutableList()
        mutableIntervals.add(newInterval)
        mutableIntervals.sortWith(CustomComparator())
        for (i in mutableIntervals) {
            print(i[0])
            println(i[1])
        }
        val ans: MutableList<IntArray> = mutableListOf()
        ans.add(mutableIntervals[0])
        for (i in 1 until mutableIntervals.size) {
            if (mutableIntervals[i][0] <= ans.last()[0]) {
                ans.last()[1] = max(ans.last()[1], mutableIntervals[i][1])
            } else {
                ans.add(mutableIntervals[i])
            }
        }
        return ans.toTypedArray()
    }
}
