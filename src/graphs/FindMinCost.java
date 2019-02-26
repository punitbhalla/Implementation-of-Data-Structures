package graphs;

public class FindMinCost {

    public static int findMinCost(int[][] grid) {

        return findMinCostUtil(grid, 2, 2);
    }

    private static int findMinCostUtil(int[][] grid, int i, int j) {

        int[][] dist = new int[i + 1][j + 1];
        dist[0][0] = grid[0][0];

        for (int k = 1; k <= i; k++) {
            dist[k][0] = dist[k - 1][0] + grid[k][0];
        }

        for (int l = 1; l <= j; l++) {
            dist[0][l] = dist[0][l - 1] + grid[0][l];
        }

        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                dist[k][l] = grid[k][l] + Math.min(grid[k - 1][l], grid[k][l - 1]);
            }
        }
        return dist[i][j];

    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 8, 9}, {1, 5, 3}};
        System.out.println(findMinCost(grid));
    }
}
