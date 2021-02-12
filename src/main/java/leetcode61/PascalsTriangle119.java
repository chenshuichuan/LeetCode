package leetcode61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle119 {
    public static void main(String[] args) {
        PascalsTriangle119 p = new PascalsTriangle119();
        for (int i = 0; i < 8; i++) {
            p.getRow(i);
        }
    }
    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        if(rowIndex<2)return null;
        int[] dp = new int[rowIndex];
        dp[0] = 1;
        dp[1] = 1;
        for(int i =2;i<rowIndex;i++){
            int bef = 1;
            for(int j = 1;j<i-1;j++){
                int temp = dp[j];
                dp[j] = bef+dp[j];
                bef = temp;
            }
            dp[i-1] = 1;
        }
        System.out.println(Arrays.toString(dp));
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<rowIndex;i++){
            res.add(dp[i]);
        }
        return res;
    }
}
