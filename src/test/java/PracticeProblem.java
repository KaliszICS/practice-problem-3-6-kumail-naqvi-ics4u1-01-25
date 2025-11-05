public class PracticeProblem {

    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length, cols = maze[0].length;
        int sr = rows - 1, sc = 0;
        if ("*".equals(maze[sr][sc])) return -1;

        int ans = minMovesUpRight(maze, sr, sc, 0);
        return (ans >= 1_000_000_000) ? -1 : ans;
    }

    static int minMovesUpRight(String[][] m, int r, int c, int moves) {
        int rows = m.length, cols = m[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols) return 1_000_000_000;
        if ("*".equals(m[r][c])) return 1_000_000_000;
        if ("F".equals(m[r][c])) return moves;

        int right = minMovesUpRight(m, r, c + 1, moves + 1);
        int up    = minMovesUpRight(m, r - 1, c, moves + 1);
        return Math.min(right, up);
    }

    public static int noOfPaths(String[][] maze) {
        int rows = maze.length, cols = maze[0].length;
        int sr = rows - 1, sc = 0;
        if ("*".equals(maze[sr][sc])) return 0;
        return countPathsUpRight(maze, sr, sc);
    }


    static int countPathsUpRight(String[][] m, int r, int c) {
        int rows = m.length, cols = m[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols) return 0;
        if ("*".equals(m[r][c])) return 0;
        if ("F".equals(m[r][c])) return 1;
        return countPathsUpRight(m, r, c + 1)
             + countPathsUpRight(m, r - 1, c);
    }
}
