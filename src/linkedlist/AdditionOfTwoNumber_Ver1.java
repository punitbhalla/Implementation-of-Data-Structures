package linkedlist;

public class AdditionOfTwoNumber_Ver1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode prev = null;
        ListNode node = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry + ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);
            carry = (sum / 10 > 0) ? 1 : 0;
            node = new ListNode(sum % 10);
            if (result == null) {
                result = node;
            } else {
                prev.next = node;
            }
            prev = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            node = new ListNode(carry);
            carry = 0;
            prev.next = node;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode node4 = new ListNode(1);
        node4.next = null;

        ListNode result = addTwoNumbers(node1, node4);
        ListNode.printList(result);
    }
}
