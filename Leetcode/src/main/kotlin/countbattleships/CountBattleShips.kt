package countbattleships

import kotlin.properties.Delegates

class CountBattleShips {
    var n by Delegates.notNull<Int>()
    var m by Delegates.notNull<Int>()
    lateinit var board: Array<CharArray>
    private fun dfs(x: Int, y: Int) {
        if (!isValidPosition(x, y)) { return }
        board[x][y] = '.'
        listOf(listOf(0, -1), listOf(-1, 0), listOf(0, 1), listOf(1, 0)).forEach { dxy ->
            if (isValidPosition(x + dxy[0], y + dxy[1])) {
                dfs(x + dxy[0], y + dxy[1])
            }
        }
    }
    private fun isValidPosition(x: Int, y: Int): Boolean =
        x in 0 until n && y in 0 until m && board[x][y] != 'X'
    fun countBattleships(board: Array<CharArray>): Int {
        var ans = 0
        this.n = board.size; this.m = board[0].size
        this.board = board
        this.board.forEachIndexed { i, row ->
            row.forEachIndexed { j, value ->
                if (value == 'X') {
                    dfs(i, j)
                    ans++
                }
            }
        }
        return ans
    }
}
