package arrays_and_strings;

public class wordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board == null) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, visited, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (board[i][j] == word.charAt(0)) {
            visited[i][j] = true;
            if (word.length() == 1) {
                return true;
            }

            // up
            if (i > 0 && !visited[i - 1][j]) {
                if (dfs(board, visited, i - 1, j, word.substring(1))) {
                    return true;
                }
            }
            //down
            if (i < board.length - 1 && !visited[i + 1][j]) {
                if (dfs(board, visited, i + 1, j, word.substring(1))) {
                    return true;
                }
            }
            //left
            if (j > 0 && !visited[i][j - 1]) {
                if (dfs(board, visited, i, j - 1, word.substring(1))) {
                    return true;
                }
            }
            //right
            if (j < board[i].length - 1 && !visited[i][j + 1]) {
                if (dfs(board, visited, i, j + 1, word.substring(1))) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
