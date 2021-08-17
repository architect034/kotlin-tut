package deleteduplicates

import linkedlist.ListNode

class DeleteDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head
        var prevPrevNode = ListNode(-101)
        var prevNode = ListNode(-101)
        prevPrevNode.next = prevNode
        prevNode.next = null
        var finalHead: ListNode? = prevPrevNode
        var headRef = head
        while (headRef != null) {
            if (headRef.next != null && headRef.`val` == headRef.next!!.`val`) {
                val value = headRef.`val`
                while (headRef != null && headRef.`val` == value) {
                    headRef = headRef.next
                }
                println(headRef)
            } else {
                val node = ListNode(headRef.`val`)
                prevNode.next = node
                prevNode = prevNode.next!!
                headRef = headRef.next
            }
        }
        while (finalHead != null && finalHead.`val` == -101) {
            finalHead = finalHead.next
        }
        return finalHead
    }
}
