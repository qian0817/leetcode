package leetcode

import java.util.*

object KotlinMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val solution = Solution()
        //304
        println(solution.stoneGameV(intArrayOf(68, 75, 25, 50, 34, 29, 77, 1, 2, 69)))
        //        System.out.println(solution.stoneGameV(new int[]{6, 2, 3, 4, 5, 5}));
//        System.out.println(solution.stoneGameV(new int[]{7, 7, 7, 7, 7, 7, 7}));
//        System.out.println(solution.stoneGameV(new int[]{2, 1, 1}));
//        System.out.println(solution.stoneGameV(new int[]{4}));
    }

    internal class Solution {
        var map: MutableMap<Pair<Int, Int>, Int> = HashMap()
        fun stoneGameV(stoneValue: IntArray): Int {
            return stoneGameV(stoneValue, 0, stoneValue.size)
        }

        fun stoneGameV(stoneValue: IntArray, left: Int, right: Int): Int {
            if (right - left <= 1) {
                return 0
            }
            val pair = left to right
            if (map.containsKey(pair)) {
                println(1)
                return map[pair]!!
            }
            var max = 0
            for (i in left until right) {
                var leftValue = 0
                var rightValue = 0
                for (j in left until i) {
                    leftValue += stoneValue[j]
                }
                for (j in i until right) {
                    rightValue += stoneValue[j]
                }
                var temp = 0
                if (leftValue > rightValue) {
                    temp = Math.max(temp, rightValue + stoneGameV(stoneValue, i, right))
                } else if (leftValue < rightValue) {
                    temp = Math.max(temp, leftValue + stoneGameV(stoneValue, left, i))
                } else {
                    temp = Math.max(temp, rightValue + stoneGameV(stoneValue, i, right))
                    temp = Math.max(temp, leftValue + stoneGameV(stoneValue, left, i))
                }
                max = Math.max(max, temp)
            }
            map[pair] = max
            return max
        }
    }
}