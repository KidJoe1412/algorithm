package leetcode;
/**
 * 题干：695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * ******************************************************
 * 解法：借鉴二叉树的dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/max-area-of-island/"></a>
 * ******************************************************
 */
public class Q695 {
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1){
                    dfs(grid,r,c);
                }
                ans = Math.max(ans,area);
                area = 0;
            }
        }
        return ans;
    }

    public void dfs(int[][] grid,int r,int c){
        // 越界
        if(!inArea(grid,r,c)) return;
        // 非岛屿
        if (grid[r][c] != 1) return;

        // 遍历过的陆地修改标志位
        grid[r][c] = 2;
        // 面积+1
        area++;
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public boolean inArea(int[][] grid,int r,int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}

