package leetcode;
/**
 * 题干：多数元素
 *给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/majority-element/"></a>
 * ******************************************************
 */
class Q169 {
    public int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;
        for(int i = 0; i < nums.length ;i++){
            if(count == 0){
                ans = nums[i];
                count++;
            }else{
                if(ans != nums[i]) count--;
                else count++;
            }
        }
        return ans;
    }
}
