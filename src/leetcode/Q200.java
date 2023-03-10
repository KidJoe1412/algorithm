package leetcode;

/**
 * 题干：岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * ******************************************************
 * 解法：借鉴二叉树的dfs
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/number-of-islands/description/"></a>
 * ******************************************************
 */
public class Q200 {
    public int numIslands(char[][] grid) {
        int count = 0; // 记录岛屿数量
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1'){
                    dfs(grid,r,c);
                    count++;
                }

            }
        }
        return count;
    }

    public void dfs(char[][] grid,int r,int c){
        // 越界
        if(!inArea(grid,r,c)) return;
        // 非岛屿
        if (grid[r][c] != '1') return;

        // 遍历过的陆地修改标志位
        grid[r][c] = '2';

        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    public boolean inArea(char[][] grid,int r,int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}















