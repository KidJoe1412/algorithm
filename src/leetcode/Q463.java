package leetcode;

/**
 *题干:计算这个岛屿的周长
 *给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * ******************************************************************
 * 解法：借鉴二叉树的dfs
 * ******************************************************************
 * 原题：<a href="https://leetcode.cn/problems/island-perimeter"></a>
 * ******************************************************************
 **/
class Q463 {
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid,r,c);
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 超出网格范围返回一条周长边
        if (!inArea(grid,r,c)) return 1;
        // 当前格子是海洋格子，返回一条周长边
        if (grid[r][c] == 0) return 1;
        // 已经遍历过的陆地格子，和周长没关系
        if (grid[r][c] != 1) return 0;
        // 当前是没有遍历过的陆地格子
        grid[r][c] = 2;
        return dfs(grid,r-1,c) + dfs(grid,r+1,c)
                + dfs(grid,r,c-1) + dfs(grid,r,c+1);
    }

    /**
     * @param grid 二维数组
     * @param r 行
     * @param c 列
     * @return 是否处于二维数组里面（未越界）
     */
    public boolean inArea(int[][] grid,int r,int c){
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
















