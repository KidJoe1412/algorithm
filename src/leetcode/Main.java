package leetcode;

import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        Q129 q129 = new Q129();
        TreeNode r4 = new TreeNode(4);
        TreeNode r9 = new TreeNode(9);
        TreeNode r0 = new TreeNode(0);
        TreeNode r5 = new TreeNode(5);
        TreeNode r1 = new TreeNode(1);

        r4.left = r9;
        r4.right = r0;
        r9.left = r5;
        r9.right = r1;

        int ans = q129.sumNumbers(r4);
        System.out.println(ans);
    }
}





















