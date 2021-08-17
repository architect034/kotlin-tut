package findpeakelement

class FindPeakElement {
    fun findPeakElement(arr: IntArray): Int {
        var index = 0
        var maxTillNow = arr[0]
        arr.forEachIndexed { currIndex, value ->
            if (value > maxTillNow) {
                maxTillNow = value
                index = currIndex
            }
        }
        return index
    }
}
