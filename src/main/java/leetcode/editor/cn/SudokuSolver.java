package leetcode.editor.cn;

//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 516 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);
        Arrays.stream(board).forEach(System.out::println);
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final boolean[][] line = new boolean[9][9];
        private final boolean[][] column = new boolean[9][9];
        private final boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        private final List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int digit = char2int(board[i][j]) - 1;
                        line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            for (int digit = 0; digit < 9 && !valid; ++digit) {
                if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    board[i][j] = int2char(digit + 1);
                    dfs(board, pos + 1);
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                }
            }
        }

        public int char2int(char c) {
            return c - '0';
        }

        public char int2char(int n) {
            return (char) (n + '0');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}