package linkedlist;

public class IntersectionOfList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA != null && headB == null) return null;
        if (headB != null && headA == null) return null;
        if (headA == null && headB == null) return null;
        int nodeCount4List1 = getNodeCount(headA);
        int nodeCount4List2 = getNodeCount(headB);
        int diff = 0;
        ListNode intersectNode = null;
        ListNode curr = null;
        if (nodeCount4List1 == nodeCount4List2) {
            intersectNode = findIntersection(headA, headB);
        } else if (nodeCount4List1 > nodeCount4List2) {
            diff = nodeCount4List1 - nodeCount4List2;
            curr = headA;
            while (diff > 0) {
                curr = curr.next;
                diff--;
            }
            intersectNode = findIntersection(curr, headB);
        } else {
            diff = nodeCount4List2 - nodeCount4List1;
            curr = headB;
            while (diff > 0) {
                curr = curr.next;
                diff--;
            }
            intersectNode = findIntersection(curr, headA);
        }
        return intersectNode;
    }

    private static int getNodeCount(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    private static ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node9 = new ListNode(9);
        node0.next = node9;
        node9.next = node1;
        node1.next = node2;
        node2.next = node4;
        node3.next = node2;

        System.out.println(getIntersectionNode(node0, node3).val);

    }
}
