package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题干：课程表 II
 *现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
  * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * ******************************************************
 * 解法：拓扑排序+dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/course-schedule-ii/description/"></a>
 * ******************************************************
 */
class Q210 {
    List<List<Integer>> arr; // 邻接表
    int[] in; // 入度表
    int[] ans; // 结果表
    int index; // 索引，判断是否结点是否全部删去
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        in = new int[numCourses];
        ans = new int[numCourses];
        index = 0;
        arr = new ArrayList<List<Integer>>();
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            arr.add(new ArrayList<Integer>());
        }

        // 构建邻接表
        for (int[] info : prerequisites) {
            arr.get(info[1]).add(info[0]);
            in[info[0]]++;
        }

        // 初始入度为0的先入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0)
                queue.add(i);
        }

        // 开始循环
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            ans[index++] = poll;
            for (Integer x : arr.get(poll)) {
                in[x]--;
                if (in[x] == 0){
                    queue.add(x);
                }
            }
        }

        // 队列是否删除完毕
        if (index == numCourses){
            return ans;
        }else {
            return new int[0];
        }
    }
}




















