package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 题干：复原 IP 地址
 *有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * ******************************************************
 * 解法：回溯
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/restore-ip-addresses/description/"></a>
 * ******************************************************
 */
class Q93 {
    List<String> ans = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>(4);
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return ans;
        dfs(s,0,4,path,ans);
        return ans;
    }
    // dfs四个参数分别为原字符串、开始索引、剩下多少段未分割、当前段字符串、最后结果
    public void dfs(String s,int start,int flag,Deque<String> path,List<String> ans){
        // 遍历完了
        if (start == s.length()){
            // 已经分割成四份了
            if (flag == 0){
                ans.add(String.join(".",path));
            }
            return;
        }

        for (int i = start; i < start + 3; i++) {
            // 越界
            if (i >= s.length()){
                break;
            }
            // 后续部分太长了
            if (s.length() - i > flag * 3){
                continue;
            }
            if (isValid(s.substring(start,i + 1))){
                String temp = s.substring(start,i + 1);
                path.addLast(temp);
                dfs(s,i + 1,flag - 1,path,ans);
                path.removeLast();
            }
        }
    }

    // 判断字符串是否合法
    public boolean isValid(String s){
        // 0开头,长度不为1
        if (s.charAt(0) == '0' && s.length() > 1)
            return false;
        // 大于255
        if (Integer.parseInt(s) > 255)
            return false;
        // 包含其他字符
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}



















