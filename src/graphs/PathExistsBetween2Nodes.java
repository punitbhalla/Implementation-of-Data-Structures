package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathExistsBetween2Nodes {

    static class Vertex {
        private int row;
        private int col;

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

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        private boolean isVisited;

        public Vertex(int row, int col, boolean isVisited) {
            this.row = row;
            this.col = col;
            this.isVisited = isVisited;
        }
    }

    static List<Vertex> vertices;
    static Vertex source = null;
    static Vertex destination = null;

    private static Vertex getVertex(int row, int col) {
        for (Vertex vertex : vertices) {
            if (vertex.getRow() == row && vertex.getCol() == col) {
                return vertex;
            }
        }
        return null;
    }


    private static boolean isPathExists(int[][] matrix) {
        processVertices(matrix);
        return bfs(matrix, source, destination);
    }

    private static boolean bfs(int[][] matrix, Vertex source, Vertex destination) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(source);
        Vertex temp = null;
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            vertex.setVisited(true);
            if (matrix[vertex.getRow()][vertex.getCol()] == 2) {
                return true;
            }

            //up
            temp = getVertex(vertex.getRow() - 1, vertex.getCol());
            if (temp != null && !temp.isVisited()) {
                queue.offer(temp);
            }

            //down
            temp = getVertex(vertex.getRow() + 1, vertex.getCol());
            if (temp != null && !temp.isVisited()) {
                queue.offer(temp);
            }
            //left
            temp = getVertex(vertex.getRow(), vertex.getCol() - 1);
            if (temp != null && !temp.isVisited()) {
                queue.offer(temp);
            }
            //right
            temp = getVertex(vertex.getRow(), vertex.getCol() + 1);
            if (temp != null && !temp.isVisited()) {
                queue.offer(temp);
            }
        }
        return false;
    }

    private static void processVertices(int[][] matrix) {
        vertices = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Vertex vertex = null;
                if (matrix[i][j] == 1) {
                    vertex = new Vertex(i, j, true);
                    source = vertex;
                } else if (matrix[i][j] == 2) {
                    vertex = new Vertex(i, j, false);
                    destination = vertex;
                } else if (matrix[i][j] == 3) {
                    vertex = new Vertex(i, j, false);
                } else {
                    vertex = new Vertex(i, j, true);
                }
                vertices.add(vertex);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 0, 0}, {0, 3, 3, 0}, {0, 1, 0, 3}, {0, 2, 3, 3}};
        System.out.println(isPathExists(matrix));
    }

}
