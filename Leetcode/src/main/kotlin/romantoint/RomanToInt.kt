package romantoint

class RomanToInt {
    fun romanToInt(s: String): Int {
        var ans = 0
        val hashMap: HashMap<Char, Int> = hashMapOf(
            Pair('I', 1),
            Pair('V', 5),
            Pair('X', 10),
            Pair('L', 50),
            Pair('C', 100),
            Pair('D', 500),
            Pair('M', 1000)
        )
        s.forEachIndexed { index, char ->
            if (index == 0) ans += hashMap[char]!!
            else {
                if (hashMap[char]!! < hashMap[s[index - 1]]!!) {
                    ans = hashMap[char]!! - ans
                } else {
                    ans += hashMap[char]!!
                }
            }
        }
        return ans
    }
}
