package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 题干：二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * ******************************************************
 * 解法：BFS
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/"></a>
 * ******************************************************
 */
class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size  = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                if (i == size - 1) // 如果是最右边的，则加入答案
                    list.add(node.val);
            }
        }
        return list;
    }
}

















