package leetcode;

import java.util.Stack;

/**
 * 题干：最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/longest-valid-parentheses/description/"></a>
 * ******************************************************
 */
class Q32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i - stack.peek());
                }
            }
        }
        return max;
    }
}









