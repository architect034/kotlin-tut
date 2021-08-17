package candy

class Candy {
    fun candy(ratings: IntArray): Int {
        val len = ratings.size
        val candiesArray = MutableList(len) { 1 }
        for (index in 1 until len) {
            if (ratings[index] > ratings[index - 1]) {
                candiesArray[index] = candiesArray[index - 1] + 1
            }
        }
        for (index in len - 2 downTo 0) {
            if (ratings[index] > ratings[index + 1]) {
                candiesArray[index] = candiesArray[index].coerceAtLeast(candiesArray[index + 1] + 1)
            }
        }
        return candiesArray.reduce { totalCandies, candies ->
            totalCandies + candies
        }
    }
}
