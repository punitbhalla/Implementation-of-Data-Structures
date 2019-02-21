package linkedlist;

public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode curr = head;
        ListNode temp = head;
        ListNode prev = null;
        while (n > 0 && temp != null) {
            temp = temp.next;
            n--;
        }
        if (temp == null) {
            head = curr.next;
            return head;
        }
        while (curr != null && temp != null) {
            prev = curr;
            curr = curr.next;
            temp = temp.next;
        }
        prev.next = curr.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode.printList(removeNthFromEnd(node1, 3));
    }
}
