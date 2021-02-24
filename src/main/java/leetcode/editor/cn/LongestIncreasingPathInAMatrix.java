package leetcode.editor.cn;

//给定一个整数矩阵，找出最长递增路径的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。 
//
// 示例 1: 
//
// 输入: nums = 
//[
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//] 
//输出: 4 
//解释: 最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2: 
//
// 输入: nums = 
//[
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//] 
//输出: 4 
//解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
// Related Topics 深度优先搜索 拓扑排序 记忆化 
// 👍 275 👎 0

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(
                new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}}));
        System.out.println(solution.longestIncreasingPath(
                new int[][]{
                        {3, 4, 5},
                        {3, 2, 6},
                        {2, 2, 1}}));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] distance;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int n = matrix.length;
            int m = matrix[0].length;
            int ans = 0;
            distance = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, dfs(matrix, i, j));
                }
            }
            return ans;
        }

        private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        private int dfs(int[][] matrix, int i, int j) {
            if (distance[i][j] != 0) {
                return distance[i][j];
            }
            distance[i][j]++;

            for (int[] dir : dirs) {
                int x1 = dir[0] + i;
                int y1 = dir[1] + j;
                if (x1 >= 0 && x1 < matrix.length && y1 >= 0 && y1 < matrix[0].length && matrix[x1][y1] > matrix[i][j]) {
                    distance[i][j] = Math.max(distance[i][j], dfs(matrix, x1, y1) + 1);
                }
            }
            return distance[i][j];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}