//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找 
// 👍 153 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int n = heights.length;
            int m = heights[0].length;
            int max = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            boolean[][] visited = new boolean[n][m];
            queue.add(new int[]{0, 0, 0});
            while (!queue.isEmpty()) {
                int[] remove = queue.remove();
                if (visited[remove[0]][remove[1]]) {
                    continue;
                }
                max = Math.max(max, remove[2]);
                if (remove[0] == n - 1 && remove[1] == m - 1) {
                    return max;
                }
                visited[remove[0]][remove[1]] = true;
                add(queue, remove[0] + 1, remove[1], remove[0], remove[1], heights, visited);
                add(queue, remove[0] - 1, remove[1], remove[0], remove[1], heights, visited);
                add(queue, remove[0], remove[1] + 1, remove[0], remove[1], heights, visited);
                add(queue, remove[0], remove[1] - 1, remove[0], remove[1], heights, visited);
            }
            return -1;
        }

        private void add(PriorityQueue<int[]> queue, int x, int y, int i, int j, int[][] heights, boolean[][] visited) {
            int n = heights.length;
            int m = heights[0].length;
            if (x < 0 || x >= n || y < 0 || y >= m) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            queue.add(new int[]{x, y, Math.abs(heights[x][y] - heights[i][j])});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}