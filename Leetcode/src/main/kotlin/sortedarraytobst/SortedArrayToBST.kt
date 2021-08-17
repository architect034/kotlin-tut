package sortedarraytobst

import tree.TreeNode

class SortedArrayToBST {
    private fun sortedArrayToBSTUtil(start: Int, end: Int, arr: IntArray): TreeNode? {
        if (start > end) return null
        val mid = (start + end) / 2
        val node = TreeNode(arr[mid])
        node.left = sortedArrayToBSTUtil(start, mid - 1, arr)
        node.right = sortedArrayToBSTUtil(mid + 1, end, arr)
        return node
    }
    fun sortedArrayToBST(arr: IntArray): TreeNode? = sortedArrayToBSTUtil(0, arr.lastIndex, arr)
}
