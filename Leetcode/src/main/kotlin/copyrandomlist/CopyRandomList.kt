package copyrandomlist

import randomNode.Node

class CopyRandomList {
    private val hashMap: HashMap<Node?, Node?> = hashMapOf()
    fun copyRandomList(node: Node?): Node? {
        var head = node
        var ansHead: Node? = null
        var ansHeadRef = ansHead
        while (head != null) {
            if (ansHead == null) {
                ansHead = Node(head.`val`)
                ansHeadRef = ansHead
            } else {
                ansHeadRef?.next = Node(head.`val`)
                ansHeadRef = ansHeadRef?.next
            }
            hashMap[head] = ansHeadRef
            head = head.next
        }
        head = node
        while (head != null) {
            val from = head
            val to = head.random
            hashMap[from]?.random = hashMap[to]
            head = head.next
        }
        return ansHead
    }
}
