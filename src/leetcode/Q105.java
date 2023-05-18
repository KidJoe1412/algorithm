package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题干：从前序与中序遍历序列构造二叉树
 *给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/"></a>
 * ******************************************************
 */
class Q105{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return part(preorder,inorder,map,0, preorder.length,0,inorder.length);
    }

    private TreeNode part(int[] preorder, int[] inorder, HashMap<Integer, Integer> map,
                          int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart >= pEnd) return null;
        int val = preorder[pStart]; // root的val
        int index = map.get(val); // root在中序遍历的index
        TreeNode root = new TreeNode(val);
        int lNum = index - iStart; // 左子树的结点数量

        root.left = part(preorder,inorder,map,pStart + 1,pStart + 1 + lNum,iStart,index);
        root.right = part(preorder,inorder,map,pStart + 1 + lNum,pEnd,index + 1,iEnd);
        return root;
    }
}

