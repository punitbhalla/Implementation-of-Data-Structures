package trees;

import java.util.LinkedList;

public class DeleteNodeBST {
    static LinkedList<TreeNode> nodeTrace;
    static TreeNode rootNode;

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        rootNode = root;
        TreeNode node = find(key);
        if (node.val != key) {
            return rootNode;
        }
        int result = node.val;
        if (node.left == null || node.right == null) {
            byPass(node);
        } else {
            nodeTrace.offer(node);
            TreeNode minRight = find(node.right, key);
            node.val = minRight.val;
            byPass(minRight);
        }
        return rootNode;
    }

    private static TreeNode find(int key) {
        nodeTrace = new LinkedList<>();
        nodeTrace.offer(null);
        return find(rootNode, key);
    }

    private static TreeNode find(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        while (true) {
            if (key < root.val) {
                if (root.left == null) {
                    break;
                } else {
                    nodeTrace.offer(root);
                    root = root.left;
                }
            } else if (key == root.val) {
                break;
            } else {
                if (root.right == null) {
                    break;
                } else {
                    nodeTrace.offer(root);
                    root = root.right;
                }
            }
        }
        return root;
    }

    private static void byPass(TreeNode node) {
        TreeNode parent = nodeTrace.removeLast();
        TreeNode child = node.left == null ? node.right : node.left;
        if (parent == null) {
            rootNode = child;
        } else if (parent.left == node) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        int key = 3;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = node6;
        System.out.println("Before removing key :" + key);
        TreeNode.inorderTraversal(node1);
        System.out.println();
        System.out.println("After removing key :" + key);
        TreeNode.inorderTraversal(deleteNode(node1, 3));
    }
}
