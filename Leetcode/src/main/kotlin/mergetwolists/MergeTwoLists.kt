package mergetwolists

import linkedlist.ListNode

class MergeTwoLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var headRef: ListNode? = null
        var head = headRef
        var head1 = l1
        var head2 = l2
        while (head1 != null && head2 != null) {
            if (head1.`val` < head2.`val`) {
                if (headRef == null) {
                    headRef = head1
                    head = headRef
                } else {
                    headRef.next = head1
                    headRef = headRef.next
                }
                head1 = head1.next
            } else {
                if (headRef == null) {
                    headRef = head2
                    head = headRef
                } else {
                    headRef.next = head2
                    headRef = headRef.next
                }
                head2 = head2.next
            }
        }
        while (head1 != null) {
            if (headRef == null) {
                headRef = head1
                head = headRef
            } else {
                headRef.next = head1
                headRef = headRef.next
            }
            head1 = head1.next
        }
        while (head2 != null) {
            if (headRef == null) {
                headRef = head2
                head = headRef
            } else {
                headRef.next = head2
                headRef = headRef.next
            }
            head2 = head2.next
        }
        return head
    }
}
