// 未完成
package leetcode;

import java.util.*;
/**
 * 题干：827. 最大人工岛
 *给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * ******************************************************
 * 解法：借鉴二叉树的dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/making-a-large-island/"></a>
 * ******************************************************
 */
public class Q827 {
    int tempArea = 0; // 用来计算每块岛屿的面积
    int index = 2; // 岛屿编号从2开始
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 1;
        int ans = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 第一次遍历陆地
        for (int r  = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1){
                    dfs(grid,r,c);
                    map.put(index++,tempArea);
                    tempArea = 0;
                }
            }
        }
        if (map.isEmpty()) return 1; // 没有陆地全是海洋

        // 第二次遍历海洋
        for (int r  = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0){
                    dfs2(grid,r,c);

                }
            }
        }

        return 0;
    }
    private void dfs2(int[][] grid, int r, int c) {
        // 边界
        if (!inArea(grid,r,c)) return;
        // 非陆地
        if (grid[r][c] != 1) return;

        grid[r][c] = index;
        tempArea++;
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
    private void dfs(int[][] grid, int r, int c) {
        // 边界
        if (!inArea(grid,r,c)) return;
        // 非陆地
        if (grid[r][c] != 1) return;

        grid[r][c] = index;
        tempArea++;
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }


    public boolean inArea(int[][] grid,int r, int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}



