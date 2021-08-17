package treetraversal

import tree.TreeNode
import java.util.ArrayDeque
import java.util.Queue

class LevelOrder {
    private val levels: MutableList<MutableList<Int>> = mutableListOf()
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var que: Queue<TreeNode> = ArrayDeque()
        if (root == null) {
            return levels
        }
        que.add(root)
        while (que.isNotEmpty()) {
            val tempQue = ArrayDeque<TreeNode>()
            val level = mutableListOf<Int>()
            que.forEach {
                level.add(it.`val`)
                if (it.left != null) {
                    tempQue.add(it.left)
                }
                if (it.right != null) {
                    tempQue.add(it.right)
                }
            }
            levels.add(level)
            que = tempQue
        }
        return levels
    }
}
