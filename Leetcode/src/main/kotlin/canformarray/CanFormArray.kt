package canformarray
class CanFormArray {
    fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
        var index = 0
        val visited = Array(pieces.size) { 0 }
        while (index < arr.size) {
            var piecePosition = 0
            while (piecePosition < pieces.size && pieces[piecePosition][0] != arr[index]) {
                piecePosition++
            }
            if (piecePosition < pieces.size && visited[piecePosition] == 0) {
                for (i in pieces[piecePosition]) {
                    if (index < arr.size && i == arr[index]) {
                        index++
                        continue
                    } else {
                        return false
                    }
                }
                visited[piecePosition] = 1
            } else {
                return false
            }
        }
        return true
    }
}
