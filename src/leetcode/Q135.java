package leetcode;
/**
 * 题干：分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * ******************************************************
 * 解法：先左遍历，然后再右遍历
 * ******************************************************
 * 原题：<a href=""></a>
 * ******************************************************
 */
// 两次遍历做法
class Q135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n]; // 结果数组
        int lRate = ratings[0];
        int rRate = ratings[n - 1];

        // 初始化
        for (int i = 0; i < n; i++) {
            ans[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (lRate < ratings[i]) { // 评分高的糖果数要多一个
                ans[i] += 1;
            }
            lRate = ratings[i]; // 更新左边的评分
        }

        for (int i = n - 2; i >= 0; i--) {
            if (rRate < ratings[i]) { // 评分高的糖果数要多一个
                ans[i] += 1;
            }
            rRate = ratings[i]; // 更新右边的评分
        }

        // 遍历加1
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ans[i];
        }

        return sum;
    }
}









