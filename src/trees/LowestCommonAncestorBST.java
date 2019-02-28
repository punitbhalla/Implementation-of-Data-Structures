package trees;

public class LowestCommonAncestorBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        TreeNode node = root;
        while (node != null) {
            int parentVal = node.val;
            if (p.val > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (p.val < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = null;
        node3.left = null;
        node3.right = node5;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        System.out.println(lowestCommonAncestor(node1, node4, node2).val);
    }
}
