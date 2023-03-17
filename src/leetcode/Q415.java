package leetcode;
/**
 * 题干：字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * ******************************************************
 * 解法：从后往前遍历，短的前面补0，都添加到sb里面，最后反转sb即可
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/add-strings/"></a>
 * ******************************************************
 */
public class Q415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0; // 进位
        int temp = 0; // 相加后的暂时结果
        int res = 0; // 去掉进位后的结果
        StringBuilder sb = new StringBuilder(); // 结果

        while (i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            temp = n1 + n2 + carry;
            carry = temp / 10;
            res = temp % 10;
            sb.append(res);
            i--;j--;
        }
        if (carry == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

















