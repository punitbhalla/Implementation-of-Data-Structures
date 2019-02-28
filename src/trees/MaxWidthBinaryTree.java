package trees;


import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
    static class CustomNode {
        TreeNode node;
        int pos;
        int depth;

        public CustomNode(TreeNode node, int pos, int depth) {
            this.node = node;
            this.pos = pos;
            this.depth = depth;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(new CustomNode(root, 0, 0));
        int left = 0;
        int maxWidth = 0;
        int currentDepth = 0;
        while (!queue.isEmpty()) {
            CustomNode customNode = queue.poll();
            if (customNode.node != null) {
                queue.offer(new CustomNode(customNode.node.left, customNode.pos * 2, customNode.depth + 1));
                queue.offer(new CustomNode(customNode.node.right, (customNode.pos * 2) + 1, customNode.depth + 1));
                if (currentDepth != customNode.depth) {
                    currentDepth = customNode.depth;
                    left = customNode.pos;
                }
                maxWidth = Math.max(maxWidth, customNode.pos - left + 1);
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = node6;
        System.out.println(widthOfBinaryTree(node1));
    }
}
