package ladderlength

import java.lang.StringBuilder
import java.util.ArrayDeque
import java.util.Queue
import kotlin.collections.HashMap

class FindLadders {
    val listOfLadders: MutableList<MutableList<String>> = mutableListOf()
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val mapOfParents: MutableMap<String, MutableSet<String>> = mutableMapOf()
        val isInDictionary: HashMap<String, Boolean> = HashMap()
        val isVisited: HashMap<String, Boolean> = HashMap()
        for (word in wordList) {
            isInDictionary.computeIfAbsent(word) { return@computeIfAbsent true }
            isVisited.computeIfAbsent(word) { return@computeIfAbsent false }
        }
        var queue: Queue<String> = ArrayDeque()
        var didWeReach = false
        queue.add(beginWord)
        while (queue.isNotEmpty()) {
            val newQueue: Queue<String> = ArrayDeque()
            while (queue.isNotEmpty()) {
                val word = StringBuilder(queue.peek())
                queue.remove()
                for (index in word.indices) {
                    val originalWord = word.toString()
                    val originalCharacter = word[index]
                    for (ch in 'a'..'z') {
                        word[index] = ch
                        val stringWord = word.toString()
                        if (isInDictionary[stringWord] == true) {
                            if (mapOfParents[word.toString()] == null) {
                                mapOfParents[word.toString()] = mutableSetOf()
                            }
                            if (mapOfParents[word.toString()]?.contains(originalWord) == false) {
                                newQueue.add(word.toString())
                                mapOfParents[word.toString()]?.add(originalWord)
                            }
                        }
                        if (stringWord == endWord) {
                            didWeReach = true
                        }
                    }
                    word[index] = originalCharacter
                }
            }
            if (didWeReach) {
                break
            }
            queue = newQueue
        }
        return listOfLadders
    }
}

fun main() {
    FindLadders().findLadders("hit", "cog", mutableListOf("hot", "dot", "dog", "lot", "log", "cog"))
}
