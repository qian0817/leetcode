//视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。 
//
// 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。 
//
// 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，
//以此逐个拼写完 key 中的所有字符。 
//
// 旋转 ring 拼出 key 字符 key[i] 的阶段中： 
//
// 
// 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符
// key[i] 。 
// 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段
//）, 直至完成所有拼写。 
// 
//
// 示例： 
//
// 
//
//
// 
//
// 输入: ring = "godding", key = "gd"
//输出: 4
//解释:
// 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
// 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
// 当然, 我们还需要1步进行拼写。
// 因此最终的输出是 4。
// 
//
// 提示： 
//
// 
// ring 和 key 的字符串长度取值范围均为 1 至 100； 
// 两个字符串中都只有小写字符，并且均可能存在重复字符； 
// 字符串 key 一定可以由字符串 ring 旋转拼出。 
// Related Topics 深度优先搜索 分治算法 动态规划 
// 👍 94 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FreedomTrail {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRotateSteps("caotmcaataijjxi",
                "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRotateSteps(String ring, String key) {
            return findRotateSteps(ring, key, 0, 0);
        }

        private Map<Pair, Integer> map = new HashMap<>();

        private int findRotateSteps(String ring, String key, int n, int index) {
            if (n == key.length()) {
                return 0;
            }
            Pair pair = new Pair(n, index);
            if (map.containsKey(pair)) {
                return map.get(pair);
            }
            if (key.charAt(n) == ring.charAt(index)) {
                return 1 + findRotateSteps(ring, key, n + 1, index);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < ring.length(); i++) {
                if (key.charAt(n) == ring.charAt(i)) {
                    int step = Math.min(
                            (index - i + ring.length()) % ring.length(),
                            (i - index + ring.length()) % ring.length());
                    min = Math.min(min, findRotateSteps(ring, key, n + 1, i) + step);
                }
            }
            map.put(pair, min + 1);
            return min + 1;
        }

        class Pair {
            Integer key, value;

            public Pair(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }

            public Integer getKey() {
                return key;
            }

            public void setKey(Integer key) {
                this.key = key;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Pair pair = (Pair) o;
                return Objects.equals(key, pair.key) &&
                        Objects.equals(value, pair.value);
            }

            @Override
            public int hashCode() {
                return Objects.hash(key, value);
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}