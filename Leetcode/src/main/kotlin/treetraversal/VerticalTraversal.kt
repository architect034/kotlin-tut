package treetraversal

import tree.TreeNode
import java.util.SortedMap
import java.util.SortedSet
import kotlin.Comparator

class PairComparator {
    companion object : Comparator<Pair<Int, Int>> {
        override fun compare(o1: Pair<Int, Int>?, o2: Pair<Int, Int>?): Int {
            if (o1 == null || o2 == null) {
                return 0
            }
            return if (o1.first > o2.first) {
                1
            } else if (o1.first < o2.first) {
                -1
            } else {
                if (o1.second > o2.second) {
                    1
                } else {
                    -1
                }
            }
        }
    }
}

class VerticalTraversal {
    private val list: MutableList<MutableList<Int>> = mutableListOf()
    private val map: SortedMap<Int, MutableList<Pair<Int, Int>>> = sortedMapOf()
    fun traverse(node: TreeNode?, horizontalDistance: Int, verticalDistance: Int) {
        if (node == null) return
        map.computeIfAbsent(horizontalDistance) {
            return@computeIfAbsent mutableListOf<Pair<Int, Int>>()
        }.add(Pair(verticalDistance, node.`val`))
        traverse(node.left, horizontalDistance - 1, verticalDistance + 1)
        traverse(node.right, horizontalDistance + 1, verticalDistance + 1)
    }
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        traverse(root, 0, 0)
        val keys: SortedSet<Int> = sortedSetOf()
        map.forEach { it ->
            keys.add(it.key)
            it.value.sortWith(PairComparator)
            val temp = mutableListOf<Int>()
            it.value.forEach { pair ->
                temp.add(pair.second)
            }
            list.add(temp)
        }
        return list
    }
}
