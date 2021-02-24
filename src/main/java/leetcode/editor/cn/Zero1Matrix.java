package leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 293 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        })));
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return matrix;
            }
            int n = matrix.length;
            int m = matrix[0].length;
            Integer[][] ans = new Integer[n][m];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        queue.add(new int[]{i, j});
                        ans[i][j] = 0;
                    }
                }
            }

            int[][] directs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int a = 0;
            while (!queue.isEmpty()) {
                Queue<int[]> temp = new LinkedList<>();
                a++;
                while (!queue.isEmpty()) {
                    int[] top = queue.poll();
                    for (int[] d : directs) {
                        int x = top[0] + d[0];
                        int y = top[1] + d[1];
                        if (x >= 0 && y >= 0 && x < n && y < m && ans[x][y] == null) {
                            temp.add(new int[]{x,y});
                            ans[x][y] = a;
                        }
                    }
                }
                queue = temp;
            }

            int[][]ret=new int[n][m];
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    ret[i][j]=ans[i][j];
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}