package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMinDistance {

    static class Vertex {
        int row;
        int col;
        int dist;
        boolean isVisited;

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public Vertex(int row, int col, int dist, boolean isVisited) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.isVisited = isVisited;
        }

        @Override
        public String toString() {
            return "(" + this.getRow() + "," + this.getCol() + ") : " + this.isVisited;
        }
    }

    private static Vertex getVertex(int row, int col) {
        for (Vertex vertex : vertices) {
            if (vertex.getRow() == row && vertex.getCol() == col) {
                return vertex;
            }
        }
        return null;
    }

    static List<Vertex> vertices = null;

    public static int minimumDistance(int[][] grid, int numRows, int numCols) {

        vertices = new ArrayList<>();
        Vertex sourceVertex = null;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Vertex vertex;
                if (grid[i][j] == 1) {
                    vertex = new Vertex(i, j, grid[i][j], false);
                } else {
                    vertex = new Vertex(i, j, grid[i][j], true);
                }
                if (i == 0 && j == 0) {
                    vertex.setDist(0);
                    vertex.setVisited(true);
                    sourceVertex = vertex;
                }
                if (grid[i][j] == 9) {
                    vertex.setVisited(false);
                }
                vertices.add(vertex);
            }

        }
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(sourceVertex);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            if (grid[vertex.row][vertex.col] == 9) {
                System.out.print("Reached Target");
                System.out.println();
                return vertex.getDist();
            }

            Vertex up = getVertex(vertex.row - 1, vertex.col);
            if (up != null && !up.isVisited()) {
                System.out.print("up-->");
                up.setVisited(true);
                up.setDist(vertex.dist + 1);
                queue.add(up);
            }
            Vertex left = getVertex(vertex.row, vertex.col - 1);
            if (left != null && !left.isVisited()) {
                System.out.print("left-->");
                left.setVisited(true);
                left.setDist(vertex.dist + 1);
                queue.add(left);
            }
            Vertex down = getVertex(vertex.row + 1, vertex.col);
            if (down != null && !down.isVisited()) {
                System.out.print("down-->");
                down.setVisited(true);
                down.setDist(vertex.dist + 1);
                queue.add(down);
            }
            Vertex right = getVertex(vertex.row, vertex.col + 1);
            if (right != null && !right.isVisited()) {
                System.out.print("right-->");
                right.setVisited(true);
                right.setDist(vertex.dist + 1);
                queue.add(right);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {1, 0, 0}, {1, 9, 1}};
        int numRows = 3;
        int numCols = 3;
        System.out.println(minimumDistance(grid, numRows, numCols));
    }
}
