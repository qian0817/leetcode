package leetcode.editor.cn;

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 328 👎 0

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            if (board.length <= 1 || board[0].length <= 1) {
                return;
            }
            int n = board.length;
            int m = board[0].length;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, visited, i, 0);
                }
                if (board[i][m - 1] == 'O') {
                    dfs(board, visited, i, m - 1);
                }
            }
            for (int i = 0; i < m; i++) {
                if (board[0][i] == 'O') {
                    dfs(board, visited, 0, i);
                }
                if (board[n - 1][i] == 'O') {
                    dfs(board, visited, n - 1, i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        private void dfs(char[][] board, boolean[][] visited, int x, int y) {
            int n = board.length;
            int m = board[0].length;
            if (x < 0 || y < 0 || x >= n || y >= m) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            if (board[x][y] == 'X') {
                return;
            }
            visited[x][y] = true;
            dfs(board, visited, x + 1, y);
            dfs(board, visited, x - 1, y);
            dfs(board, visited, x, y + 1);
            dfs(board, visited, x, y - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}