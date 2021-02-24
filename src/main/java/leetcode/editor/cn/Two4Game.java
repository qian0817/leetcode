package leetcode.editor.cn;

//你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。 
//
// 示例 1: 
//
// 输入: [4, 1, 8, 7]
//输出: True
//解释: (8-4) * (7-1) = 24
// 
//
// 示例 2: 
//
// 输入: [1, 2, 1, 2]
//输出: False
// 
//
// 注意: 
//
// 
// 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。 
// 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允
//许的。 
// 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。 
// 
// Related Topics 深度优先搜索 
// 👍 219 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Two4Game {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgePoint24(int[] nums) {
            List<Double> list = IntStream.of(nums).mapToDouble(Double::valueOf).boxed().collect(Collectors.toList());
            return solve(list);
        }

        public boolean solve(List<Double> list) {
            int size = list.size();
            if (size == 0) {
                return false;
            }
            if (size == 1) {
                return Math.abs(list.get(0) - 24) < 1e-6;
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        continue;
                    }
                    LinkedList<Double> temp = new LinkedList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            temp.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        switch (k) {
                            case 0:
                                temp.add(list.get(i) + list.get(j));
                                break;
                            case 1:
                                temp.add(list.get(i) - list.get(j));
                                break;
                            case 2:
                                temp.add(list.get(i) * list.get(j));
                                break;
                            case 3:
                                if (Math.abs(list.get(j)) < 1e-2) {
                                    temp.add(list.get(i) / list.get(j));
                                }else {
                                    continue;
                                }
                                break;
                            default:
                        }
                        if (solve(temp)) {
                            return true;
                        } else {
                            temp.removeLast();
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}