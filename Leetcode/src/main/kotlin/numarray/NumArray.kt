package numarray

class NumArray(nums: IntArray) {

    private val segmentTree = SegmentTree(nums.size).apply { build(nums) }

    fun update(i: Int, v: Int) {
        segmentTree.set(i, v)
    }

    fun sumRange(i: Int, j: Int): Int {
        return segmentTree.sum(i, j + 1)
    }
}

class SegmentTree(var n: Int) {
    var size = 1
    var sums: IntArray

    init {
        adjustSize()
        sums = IntArray(2 * size)
    }

    private fun adjustSize() {
        while (size < n) size *= 2
    }

    fun build(arr: IntArray) {
        build(arr, 0, 0, size)
    }

    fun set(i: Int, v: Int) {
        set(i, v, 0, 0, size)
    }

    fun sum(l: Int, r: Int): Int {
        return sum(l, r, 0, 0, size)
    }

    private fun build(arr: IntArray, x: Int, lx: Int, rx: Int) {
        if (rx - lx == 1) {
            if (lx < arr.size) sums[x] = arr[lx]
            return
        }
        val m = (lx + rx) / 2
        build(arr, 2 * x + 1, lx, m)
        build(arr, 2 * x + 2, m, rx)
        sums[x] = sums[2 * x + 1] + sums[2 * x + 2]
    }

    private fun set(i: Int, v: Int, x: Int, lx: Int, rx: Int) {
        if (rx - lx == 1) {
            sums[x] = v
            return
        }
        val m = (lx + rx) / 2
        if (i < m) set(i, v, 2 * x + 1, lx, m)
        else set(i, v, 2 * x + 2, m, rx)
        sums[x] = sums[2 * x + 1] + sums[2 * x + 2]
    }

    private fun sum(l: Int, r: Int, x: Int, lx: Int, rx: Int): Int {
        if (lx >= r || l >= rx) return 0
        if (lx >= l && rx <= r) return sums[x]
        val m = (lx + rx) / 2
        val left = sum(l, r, 2 * x + 1, lx, m)
        val right = sum(l, r, 2 * x + 2, m, rx)
        return left + right
    }
}
