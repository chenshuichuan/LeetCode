package leetcode51;

public class HouseRobber198 {
    public static void main(String[] args){
        int[]arr = {2,7,9,3,1};
        HouseRobber198 p= new HouseRobber198();
        System.out.println(p.rob(arr));
    }
    //dp[i] i 打劫的话，获取价值
    public int rob(int[] nums) {
        int max = 0;
        if(nums.length==0)return 0;
        if(nums.length==1)return nums[1];

        int[] dp =new int[2];
        dp[0]=nums[0];
        dp[1]= nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i%2] += nums[i];
        }
        return Math.max(dp[0],dp[1]);
    }
}
