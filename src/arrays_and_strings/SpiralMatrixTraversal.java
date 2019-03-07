package arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return spiralList;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0, j = 0, k = rows - 1, l = cols - 1;

        while (i <= k && j <= l) {
            for (int col = j; col <= l; col++) {
                spiralList.add(matrix[i][col]);
            }
            for (int row = i + 1; row <= k; row++) {
                spiralList.add(matrix[row][l]);
            }

            if (i < k && j < l) {
                for (int col = l - 1; col > j; col--) {
                    spiralList.add(matrix[k][col]);
                }
                for (int row = k; row > i; row--) {
                    spiralList.add(matrix[row][j]);
                }
            }
            i++;
            k--;
            j++;
            l--;
        }

        return spiralList;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }
}
