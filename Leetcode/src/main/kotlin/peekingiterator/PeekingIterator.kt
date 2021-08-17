package peekingiterator

import kotlin.properties.Delegates

class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {
    val arr: MutableList<Int> = mutableListOf()
    var len by Delegates.notNull<Int>()
    var index = 0

    init {
        iterator.forEach {
            arr.add(it)
        }
        len = arr.size
    }
    fun peek(): Int {
        return arr[index]
    }

    override fun next(): Int {
        return arr[index++]
    }

    override fun hasNext(): Boolean {
        return index < len
    }
}
