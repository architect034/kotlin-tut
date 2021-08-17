package numberofarithmeticslices

class NumberOfArithmeticSlices {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        var ans = 0
        var i = 0
        while (i < A.size - 2) {
            var a = A[i]; var b = A[i + 1]; var c = A[i + 2]
            var curr = i
            var last = i
            while (i < A.size - 2 && (b - a) == (c - b)) {
                last = i + 2
                a = A[i]; b = A[i + 1]; c = A[i + 2]
                i++
            }
            val len = last - curr + 1
            if (len >= 3) {
                val diff = (len - 3)
                ans += (diff * (diff + 1)) / 2
            }
        }
        return ans
    }
}
