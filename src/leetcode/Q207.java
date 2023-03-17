package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题干：课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * ******************************************************
 * 解法：有向无环图，拓扑排序，dfs或者bfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/course-schedule/description/"></a>
 * ******************************************************
 */

// BFS做法
class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> ans = new ArrayList<>(); // 邻接表
        int[] inDgrees = new int[numCourses]; // 入度表
        Queue<Integer> queue = new LinkedList<>(); // 队列

        // 初始化
        for (int i = 0; i < numCourses; i++) {
            ans.add(new ArrayList<>());
        }

        // 邻接表和入度数组赋值
        for (int[] level : prerequisites) {
            ans.get(level[1]).add(level[0]);
            inDgrees[level[0]]++;
        }

        // 入度为0的结点入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDgrees[i] == 0)
                queue.add(i);
        }

        // BFS遍历
        while (!queue.isEmpty()){
            int v = queue.poll(); // 弹出的结点
            numCourses--;
            // 把以v为前驱的结点的入度减1
            for (int level : ans.get(v)) {
                if (--inDgrees[level] == 0)
                    queue.add(level);
            }
        }
        return numCourses == 0;
    }
}




















