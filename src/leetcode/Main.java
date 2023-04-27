package leetcode;
/*
父子串关系：如果一个字符串是另外一个字符串的子串，他们两个称为父子串关系  包含者称为父串，被包含者称为子串
比如：abcd abc
写一个函数，函数入参有2个字符串，函数功能如下：如果两个参数存在父子串关系，那边就把父串里面的和子串一样的字符串去掉。
生成新的字符串，比如abcdefg  bcde  那么父串变成afg。最后2个字符串不在存在父子串关系，函数结束，返回两个新的字符串。

 */
public class Main {
    static StringBuffer sb;
    static String[] ans;
    public static void main(String[] args) {
        ans = new String[2];
        sb = new StringBuffer();
        String s1 = "aaaaaaaaaa";
        String s2 = "a";
        func(s1,s2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static void func(String p,String s){ // p为父，s为子
        // 特殊情况处理...
        // 核心代码
        for (int i = 0; i < p.length(); ) {
            if (p.length() - i >= s.length()){
                if (p.substring(i,i + s.length()).equals(s)){
                    i = i + s.length();
                }else {
                    sb.append(p.charAt(i));
                    i++;
                }
            }else {
                sb.append(p.charAt(i));
                i++;
            }
        }
        ans[0] = sb.toString();
        ans[1] = s;
    }
}


   // ababcdabefg  abcd
// ababcd abcd
// ababcdcdefg abcd





/*
*
* int i = 0;
        int j = 0;
        while (i < p.length()) { // abcdefg  bcde
            char c = p.charAt(i);
            while (j < s.length()) {
                if (c == s.charAt(j)){
                    if (j == s.length() - 1){
                        break;
                    }else {

                    }
                }else {
                    j = 0;
                    break;
                }
            }
        }*/
















