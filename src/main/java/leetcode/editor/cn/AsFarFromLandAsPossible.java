//你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
//你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。 
//
// 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x
//1| + |y0 - y1| 。 
//
// 如果我们的地图上只有陆地或者海洋，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 图


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        Solution solution = new AsFarFromLandAsPossible().new Solution();
        System.out.println(solution.maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
        System.out.println(solution.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        int n;

        class Pair {
            int x, y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int maxDistance(int[][] grid) {
            n = grid.length;
            boolean[][] visited = new boolean[n][n];
            Queue<Pair> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
            if (queue.isEmpty()) {
                return -1;
            }
            int dis=0;
            while (true) {
                Queue<Pair> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    Pair pair = queue.remove();
                    add(temp,visited,pair.x-1,pair.y);
                    add(temp,visited,pair.x+1,pair.y);
                    add(temp,visited,pair.x,pair.y-1);
                    add(temp,visited,pair.x,pair.y+1);
                }
                if (temp.isEmpty()){
                    break;
                }
                dis++;
                queue=temp;
            }
            if (dis==0){
                return -1;
            }
            return dis;
        }

        public void add(Queue<Pair>queue,boolean[][]visited,int x,int y){
            if (x<0||y<0||x>=n||y>=n||visited[x][y]){
                return;
            }
            queue.add(new Pair(x,y));
            visited[x][y]=true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}