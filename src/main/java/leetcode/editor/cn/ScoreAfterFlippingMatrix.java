//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 136 👎 0


package leetcode.editor.cn;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.matrixScore(new int[][]{
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        });
        solution.matrixScore(new int[][]{
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
        });
        //[[0,0,1,1],
        //]
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] A) {
            int ans = 0;
            if (A.length == 0 || A[0].length == 0) {
                return ans;
            }
            for (int i = 0; i < A.length; i++) {
                if (A[i][0] == 0) {
                    for (int j = 0; j < A[i].length; j++) {
                        A[i][j] = A[i][j] == 1 ? 0 : 1;
                    }
                }
            }
            for (int i = 1; i < A[0].length; i++) {
                int count = 0;
                for (int j = 0; j < A.length; j++) {
                    if (A[j][i] == 1) {
                        count++;
                    }
                }
                if (count < (A.length + 1) / 2) {
                    for (int j = 0; j < A.length; j++) {
                        A[j][i] = A[j][i] == 1 ? 0 : 1;
                    }
                }
            }
            for (int[] ints : A) {
                int temp = 0;
                for (int num : ints) {
                    temp = temp * 2 + num;
                }
                ans += temp;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}