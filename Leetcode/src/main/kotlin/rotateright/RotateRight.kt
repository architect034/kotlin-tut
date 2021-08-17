package rotateright

import linkedlist.ListNode

class RotateRight {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var len = 0
        var headRef = head
        var tail = head
        while (headRef != null) {
            len++
            headRef = headRef.next
            if (headRef?.next == null) {
                tail = headRef
            }
        }
        if (len <= 1 || (k % len) == 0) return head
        headRef = head
        var move = k - k % len
        var prevHeadRef: ListNode? = null
        while (move-- > 0) {
            prevHeadRef = headRef
            headRef = headRef?.next
        }
        prevHeadRef?.next = null
        tail?.next = head
        return headRef
    }
}
