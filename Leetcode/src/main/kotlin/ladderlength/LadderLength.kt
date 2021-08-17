package ladderlength

import java.lang.StringBuilder
import java.util.ArrayDeque
import java.util.Queue
import kotlin.collections.HashMap

class LadderLength {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        var answer = 1
        val hashMap: HashMap<String, Int> = HashMap()
        val visited: HashMap<String, Boolean> = HashMap()
        for (word in wordList) {
            hashMap.computeIfAbsent((word)) {
                return@computeIfAbsent 1
            }
            visited.computeIfAbsent((word)) {
                return@computeIfAbsent false
            }
        }
        if (hashMap[endWord] != 1) return 0
        var queue: Queue<String> = ArrayDeque()
        queue.add(beginWord)
        visited[beginWord] = true
        while (queue.isNotEmpty()) {
            val newQueue: Queue<String> = ArrayDeque()
            while (queue.isNotEmpty()) {
                val word = StringBuilder(queue.peek())
                queue.remove()
                for (index in word.indices) {
                    val originalCharacter = word[index]
                    for (ch in 'a'..'z') {
                        word[index] = ch
                        val stringWord = word.toString()
                        if (stringWord == endWord) return answer + 1
                        if (hashMap[stringWord] == 1 && visited[stringWord] == false) {
                            newQueue.add(word.toString())
                            visited[word.toString()] = true
                        }
                    }
                    word[index] = originalCharacter
                }
            }
            answer++
            queue = newQueue
        }
        return 0
    }
}

fun main() {
    LadderLength().ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
}
