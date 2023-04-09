package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题干：合并区间
 *以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * ******************************************************
 * 解法：排序再判断
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/merge-intervals/description/"></a>
 * ******************************************************
 */
class Q56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0][];
        List<int[]> ans = new ArrayList<>();
        // 左端小的排前面
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < L){ // 直接加上
                ans.add(new int[]{L,R});
            }else { // 区间有覆盖,需要重构
                ans.set(ans.size() - 1,new int[]{ans.get(ans.size() - 1)[0],Math.max(ans.get(ans.size() - 1)[1],R)});
            }
        }
        return ans.toArray(new int[0][]);
    }
}



















