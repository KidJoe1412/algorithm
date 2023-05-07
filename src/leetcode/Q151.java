package leetcode;

/**
 * 题干：反转字符串中的单词
 *给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/reverse-words-in-a-string/"></a>
 * ******************************************************
 */
class Q151 {
    StringBuffer sb;
    public String reverseWords(String s) {
        sb = new StringBuffer();
        String str = s.trim();
        int i = str.length() - 1;

        while (i >= 0){
            int j = i;
            while (i >= 0 && str.charAt(i) != ' '){
                i--;
            }
            sb.append(str.substring(i + 1,j + 1));
            sb.append(' ');
            while (i >= 0 && str.charAt(i) == ' '){
                i--;
            }
        }
        return sb.toString().trim();
    }
}














