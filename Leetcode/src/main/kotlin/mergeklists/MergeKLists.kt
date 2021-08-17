package mergeklists

import linkedlist.ListNode

class MergeKLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var head: ListNode? = null
        val list = mutableListOf<Int>()
        for (headRef in lists) {
            var movingHeadRef = headRef
            while (movingHeadRef != null) {
                list.add(movingHeadRef.`val`)
                movingHeadRef = movingHeadRef.next
            }
        }
        list.sort()
        var tempHead = head
        for (value in list) {
            if (head == null) {
                tempHead = ListNode(value)
                head = tempHead
            } else {
                tempHead?.next = ListNode(value)
                tempHead = tempHead?.next
            }
        }
        return head
    }
}
