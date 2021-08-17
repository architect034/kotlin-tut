package mineatingspeed

class MinEatingSpeed {
    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var low = 1; var high = Int.MAX_VALUE / 2
        var ans = high
        while (low <= high) {
            val mid = (low + high).shr(1)
            if (isThisSpeedEnough(mid, piles, H)) {
                ans = mid
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return ans
    }

    private fun isThisSpeedEnough(speed: Int, piles: IntArray, H: Int): Boolean {
        var time = 0
        for (bananas in piles) {
            time += (bananas + speed - 1) / speed
        }
        if (time > H) return false
        return true
    }
}
