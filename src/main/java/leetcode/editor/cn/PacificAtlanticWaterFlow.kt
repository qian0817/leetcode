package leetcode.editor.cn

import java.util.*

//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 125 👎 0
object PacificAtlanticWaterFlow {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        println(solution.pacificAtlantic(arrayOf(
                intArrayOf(1, 2, 2, 3, 5),
                intArrayOf(3, 2, 3, 4, 4),
                intArrayOf(2, 4, 5, 3, 1),
                intArrayOf(6, 7, 1, 4, 5),
                intArrayOf(5, 1, 1, 2, 4))))
    }

    internal
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun pacificAtlantic(matrix: Array<IntArray>): List<List<Int>> {
            if (matrix.isEmpty() || matrix[0].isEmpty()) {
                return emptyList()
            }
            val n = matrix.size
            val m = matrix[0].size
            val visited1 = visit(matrix, true)
            val visited2 = visit(matrix, false)

            val ans = arrayListOf<List<Int>>()
            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (visited1[i][j] && visited2[i][j]) {
                        ans.add(listOf(i, j))
                    }
                }
            }

            return ans
        }

        private fun visit(matrix: Array<IntArray>, isPacific: Boolean): Array<BooleanArray> {
            val dist = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
            val n = matrix.size
            val m = matrix[0].size
            val visited = Array(n) { BooleanArray(m) }
            val queue = LinkedList<Pair<Int, Int>>()
            //初始值
            for (i in 0 until n) {
                val temp = if (isPacific) {
                    0
                } else {
                    m - 1
                }
                queue.add(Pair(i, temp))
                visited[i][temp] = true
            }

            for (i in 0 until m) {
                val temp = if (isPacific) {
                    0
                } else {
                    n - 1
                }
                queue.add(Pair(temp, i))
                visited[temp][i] = true
            }

            while (queue.isNotEmpty()) {
                val top = queue.poll()
                dist.forEach {
                    val first = top.first + it[0]
                    val second = top.second + it[1]
                    if (first < n && second < m && first >= 0 && second >= 0) {
                        if (matrix[first][second] >= matrix[top.first][top.second]) {
                            if (!visited[first][second]) {
                                queue.add(Pair(first, second))
                                visited[first][second] = true
                            }
                        }
                    }
                }
            }
            return visited
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}