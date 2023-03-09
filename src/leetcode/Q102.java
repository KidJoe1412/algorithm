package leetcode;

import java.util.*;

/**
 * 题干：给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * ****************************************************
 * 解法：广度优先遍历用队列
 * ****************************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">...</a>
 * ****************************************************
 */
class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); // 二维数组存放最终结果
        Queue<TreeNode> queue = new ArrayDeque<>(); // 用来操作的队列
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size(); // 队列大小，即每层需要遍历的次数
            List<Integer> level = new ArrayList<>(); // 最终结果里面的一维数组
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}




























