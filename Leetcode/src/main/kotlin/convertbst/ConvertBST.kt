package convertbst

import tree.TreeNode

class ConvertBST {
    private var sum = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root != null) {
            convertBST(root.right)
            sum += root.`val`
            root.`val` = sum
            convertBST(root.left)
        }
        return root
    }
}
