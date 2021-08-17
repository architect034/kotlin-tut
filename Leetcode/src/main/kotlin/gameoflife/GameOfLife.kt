package gameoflife
class GameOfLife {
    fun gameOfLife(board: Array<IntArray>) {
        val colsCount = board[0].size
        val rowsCount = board.size
        val newBoard = Array(rowsCount) {
            IntArray(colsCount) { 0 }
        }
        for (row in board.indices) {
            for (col in board[row].indices) {
                var neighbouringLives = 0
                if ((col - 1) >= 0 && board[row][col - 1] == 1) {
                    neighbouringLives++
                }
                if ((col - 1) >= 0 && (row - 1) >= 0 && board[row - 1][col - 1] == 1) {
                    neighbouringLives++
                }
                if ((row - 1) >= 0 && board[row - 1][col] == 1) {
                    neighbouringLives++
                }
                if ((row - 1) >= 0 && (col + 1) < colsCount && board[row - 1][col + 1] == 1) {
                    neighbouringLives++
                }
                if ((col + 1) < colsCount && board[row][col + 1] == 1) {
                    neighbouringLives++
                }
                if ((row + 1) < rowsCount && (col + 1) < colsCount && board[row + 1][col + 1] == 1) {
                    neighbouringLives++
                }
                if ((row + 1) < rowsCount && board[row + 1][col] == 1) {
                    neighbouringLives++
                }
                if ((row + 1) < rowsCount && (col - 1) >= 0 && board[row + 1][col - 1] == 1) {
                    neighbouringLives++
                }
                if (board[row][col] == 1) {
                    if (neighbouringLives < 2) {
                        newBoard[row][col] = 0
                    } else if (neighbouringLives > 3) {
                        newBoard[row][col] = 0
                    } else if (neighbouringLives in 2..3) {
                        newBoard[row][col] = 1
                    }
                } else if (board[row][col] == 0) {
                    if (neighbouringLives == 3) {
                        newBoard[row][col] = 1
                    } else {
                        newBoard[row][col] = 0
                    }
                }
            }
        }
        for (i in newBoard.indices) {
            for (j in newBoard[i].indices) {
                board[i][j] = newBoard[i][j]
            }
        }
    }
}
