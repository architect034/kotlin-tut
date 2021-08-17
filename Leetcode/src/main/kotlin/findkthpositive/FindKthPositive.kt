package findkthpositive

class FindKthPositive {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var missingNumberCount = 0
        var pointsTo = 0
        var index = 0
        while (missingNumberCount != k) {
            if (index < arr.size && pointsTo + 1 == arr[index++]) {
                continue
            } else {
                pointsTo++
                missingNumberCount++
            }
        }
        return pointsTo
    }
}
