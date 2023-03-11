package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int n = matrix.length * matrix[0].length; // 元素总数
        while (n > 0){
            for (int i = left; i <= right && n > 0; i++) {
                ans.add(matrix[top][i]);
                n--;
            }
            top++;

            for (int i = top; i <= bottom && n > 0; i++) {
                ans.add(matrix[i][right]);
                n--;
            }
            right--;

            for (int i = right; i >= left && n > 0; i--) {
                ans.add(matrix[bottom][i]);
                n--;
            }
            bottom--;

            for (int i = bottom; i >= top && n > 0; i--) {
                ans.add(matrix[i][left]);
                n--;
            }
            left++;
        }
        return ans;
    }
}
















