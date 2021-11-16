package leetcode71;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset368 {

    public static void main(String[] args){
        LargestDivisibleSubset368 p = new LargestDivisibleSubset368();
        int[][] nums = {{1,2,3},{1,2,4,8}};
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list =  p.largestDivisibleSubset(nums[i]);
            System.out.println(list.toString());
        }
    }
    /**最大的整除子集
     * dp[i] 表示以num[i] 结尾的最大的整除子集 的个数，dp[i] = dp[j] +1;
     * g[i] 表示dp[i] 是由dp[g[i]] 转移而来
     * */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] g = new int[nums.length];
        dp[0] = 1;
        g[0] = 0;
        //maxdp 记录count最大的子集的最后一个数
        int maxdp = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i-1;
            int maxj = -1;
            while (j>=0){
                if(nums[i] % nums[j] == 0){
                    if(maxj == -1)maxj = j;
                    else maxj = dp[j]>dp[maxj] ? j : maxj;
                }
                j--;
            }
            if(maxj == -1){
                dp[i] = 1;
                g[i] = i;
            }else{
                dp[i] =dp[maxj] +1;
                g[i] = maxj;
                maxdp = dp[i]>dp[maxdp] ? i : maxdp;
            }
        }

        //从maxdp回溯
        List<Integer> list = new ArrayList<>();
        int index = maxdp;
        while (true){
            list.add(0,nums[index]);
            if(g[index] == index)break;
            index = g[index];
        }
        return list;
    }
}
