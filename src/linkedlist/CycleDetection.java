package linkedlist;

public class CycleDetection {
    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;
        if (head.next == head) return true;

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(hasCycle(node1));
    }
}
