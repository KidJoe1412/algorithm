package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题干：给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * **********************************************
 * 解法：
 * **********************************************
 * 原题：<a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">...</a>
 * **********************************************
 */


public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); // 结果
        Deque<TreeNode> queue = new ArrayDeque<>(); // 用来操作的队列
        boolean isLeft = true; // 标志是从左往右遍历还是从右往左遍历
        if (root != null) queue.add(root);

        while (!queue.isEmpty()){
            // 精髓在于level（双端队列），怎么添加数据，是从前往后还是从后往前
            Deque<Integer> level = new ArrayDeque<>();
            int n = queue.size();

            for (int i = 0; i < n; i++) { // 每层的循环
                TreeNode node = queue.poll();
                if (isLeft)
                    level.addLast(node.val);
                else
                    level.addFirst(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            // ans.add(level.stream().toList()); //jdk版本不够好像
            isLeft = ! isLeft;
        }
        return ans;
    }
}


















