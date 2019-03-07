package graphs;

public class FindMinCost {

    public static int findMinCost(int[][] grid) {

        return findMinCostUtil(grid, 4, 4);
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
//        int[][] grid = new int[][]{{1, 2, 3}, {4, 8, 9}, {1, 5, 3}};
        int[][] grid = new int[][]{{31, 100, 65, 12, 18}, {10, 13, 47, 157, 6}, {100, 113, 174, 11, 33}, {88, 124, 41, 20, 140}, {92, 32, 111, 41, 20}};
        System.out.println(findMinCost(grid));
    }
}


/*
31, 100, 65, 12, 18,
10, 13, 47, 157, 6,
100. 113, 174, 11, 33,
88, 124, 41, 20, 140,
99, 32, 111, 41, 20
 */