package priorityqueue;

import linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = null;
        ListNode tail = result;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.getVal() - b.getVal();
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.getNext() != null) {
                pq.offer(node.getNext());
            }
            if (result == null) {
                result = node;
                tail = node;
            } else {
                tail.setNext(node);
                tail = tail.getNext();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);
        listNodes[0] = node1;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(null);
        listNodes[1] = node4;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.setNext(node8);
        node8.setNext(null);
        listNodes[2] = node7;

        ListNode.printList(mergeKLists(listNodes));
    }
}
