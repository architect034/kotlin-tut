package generateparentheses

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()
        fun solve(pos: Int, open: Int, close: Int, seq: MutableList<Char>) {
            if (close == n) {
                ans.add(seq.joinToString(""))
                return
            }
            if (close < open) {
                seq[pos] = ')'
                solve(pos + 1, open, close + 1, seq)
            }
            if (open < n) {
                seq[pos] = '('
                solve(pos + 1, open + 1, close, seq)
            }
        }
        solve(0, 0, 0, MutableList(2 * n) { '$' })
        return ans
    }
}

fun main() {
    GenerateParentheses().generateParenthesis(3)
}
