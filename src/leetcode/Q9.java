package leetcode;
/**
 * 题干：回文数
 *给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * ******************************************************
 * 解法：数字反转后和原数字比较(法二，转成字符串调用api处理)
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/palindrome-number/"></a>
 * ******************************************************
 */
class Q9 {
    // 数字法
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if(x >= 0 && x <= 9)
            return true;
        int record = x;
        int sum = 0;
        while (true){
            int i = x % 10; // 个位
            x /= 10;
            sum = sum * 10 + i;
            if (x == 0) break;
        }
        return record == sum;
    }
    // 字符串法
    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        if(x >= 0 && x <= 9)
            return true;
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer(s);
        return s.equals(sb.reverse().toString());
    }

}



















