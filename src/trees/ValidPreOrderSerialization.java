package trees;

public class ValidPreOrderSerialization {
    public static boolean isValidSerialization(String preorder) {

        String[] nodes = preorder.split(",");
        int freeEdge = 1;
        for (String node : nodes) {
            freeEdge -= 1;// every node consumes one freeEdge
            if (freeEdge < 0) return false;
            if (!node.equals("#")) {
                freeEdge += 2;// internal node gives two new edges
            }
        }
        return freeEdge == 0;
    }

    public static void main(String[] args) {
        String preOrder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preOrder));
    }
}
