package addtwonumbers

import linkedlist.ListNode
import java.util.LinkedList

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var answerList: ListNode? = null
        var headRef: ListNode? = l1
        val number1: LinkedList<Int> = LinkedList()
        val number2: LinkedList<Int> = LinkedList()
        while (headRef != null) {
            number1.add(headRef.`val`)
            headRef = headRef.next
        }
        headRef = l2
        while (headRef != null) {
            number2.add(headRef.`val`)
            headRef = headRef.next
        }
        if (number1.size < number2.size) {
            while (number1.size < number2.size) {
                number1.add(0)
            }
        } else if (number2.size < number1.size) {
            while (number2.size < number1.size) {
                number2.add(0)
            }
        }
        val answer: LinkedList<Int> = LinkedList()
        var rem = 0
        for (i in number1.indices) {
            val sum = number1[i] + number2[i]
            answer.add((sum + rem) % 10)
            rem = (sum + rem) / 10
        }
        if (rem > 0) answer.add(rem)
        var head: ListNode? = null
        for (num in answer) {
            if (answerList == null) {
                answerList = ListNode(num)
                head = answerList
            } else {
                answerList.next = ListNode(num)
                answerList = answerList.next
            }
        }
        return head
    }
}
