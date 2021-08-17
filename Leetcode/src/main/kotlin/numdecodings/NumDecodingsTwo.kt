package numdecodings

class NumDecodingsTwo {
    private var M = 1000000007
    fun numDecodings(s: String): Int {
        val memo = arrayOfNulls<Long>(s.length)
        return ways(s, s.length - 1, memo).toInt()
    }

    fun ways(s: String, i: Int, memo: Array<Long?>): Long {
        if (i < 0) return 1
        if (memo[i] != null) return memo[i]!!
        if (s[i] == '*') {
            var res = 9 * ways(s, i - 1, memo) % M
            if (i > 0 && s[i - 1] == '1') res =
                (res + 9 * ways(s, i - 2, memo)) % M else if (i > 0 && s[i - 1] == '2') res =
                (res + 6 * ways(s, i - 2, memo)) % M else if (i > 0 && s[i - 1] == '*') res =
                (res + 15 * ways(s, i - 2, memo)) % M
            memo[i] = res
            return memo[i]!!
        }
        var res = if (s[i] != '0') ways(s, i - 1, memo) else 0
        if (i > 0 && s[i - 1] == '1') res =
            (res + ways(s, i - 2, memo)) % M else if (i > 0 && s[i - 1] == '2' && s[i] <= '6') res =
            (res + ways(s, i - 2, memo)) % M else if (i > 0 && s[i - 1] == '*') res =
            (res + (if (s[i] <= '6') 2 else 1) * ways(s, i - 2, memo)) % M
        memo[i] = res
        return memo[i]!!
    }
}
