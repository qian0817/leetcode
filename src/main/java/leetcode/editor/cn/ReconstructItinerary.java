package leetcode.editor.cn;

//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 
// 👍 179 👎 0

import java.util.*;
import java.util.stream.Collectors;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] a = new String[][]{
//                {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}
                {"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}
        };
        System.out.println(solution.findItinerary(arrayToList(a)));

    }

    private static List<List<String>> arrayToList(String[][] a) {
        return Arrays.stream(a).map((value) -> Arrays.stream(value).collect(Collectors.toList())).collect(Collectors.toList());
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> itinerary = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                if (!map.containsKey(src)) {
                    map.put(src, new PriorityQueue<>());
                }
                map.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        public void dfs(String current) {
            while (map.containsKey(current) && map.get(current).size() > 0) {
                String tmp = map.get(current).poll();
                dfs(tmp);
            }
            itinerary.add(current);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}