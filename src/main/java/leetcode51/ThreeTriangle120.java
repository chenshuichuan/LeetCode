package leetcode51;

import java.util.List;

public class ThreeTriangle120 {
    public static void main(String[] args){

    }
    //dp[i][j] 代表到达i行,j列的最小和
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1)return triangle.get(0).get(0);
        int[][]dp = new int[n][triangle.get(n-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                int value = triangle.get(i).get(j);
                //size-1 的只能承接上层j-1位的
                if(j==size-1)dp[i][j] = dp[i-1][j-1]+value;
                //j==0的只能承接上层0位置的
                else if(j==0) dp[i][j] = dp[i-1][j]+value;
                else dp[i][j] = (dp[i-1][j]<dp[i-1][j-1] ? dp[i-1][j] : dp[i-1][j-1])+value;
                if(i==n-1)min = dp[i][j]<min ? dp[i][j] : min ;
            }
        }
        return min;
    }
    //dp空间优化
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1)return triangle.get(0).get(0);
        int[]dp = new int[triangle.get(n-1).size()];
        dp[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        int preDp = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int size = triangle.get(i).size();
            for (int j = 0; j < size; j++) {
                int value = triangle.get(i).get(j);
                int temp = dp[j];

                if(j==size-1)dp[j] = preDp+value;
                else if(j==0) dp[j] = dp[j]+value;
                else dp[j] = (dp[j]<preDp ? dp[j] : preDp)+value;
                if(i==n-1)min = dp[j]<min ? dp[j] : min ;
                preDp = temp;
            }
        }
        return min;
    }
}
