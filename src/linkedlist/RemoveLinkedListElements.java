package linkedlist;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {

        /*ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val == val){
                prev.next=curr.next;
            }else{
                prev=prev.next;
            }
            curr = curr.next;
        }
        return result.next;
        */

        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);
        ListNode.printList(removeElements(node1, 6));

    }
}
