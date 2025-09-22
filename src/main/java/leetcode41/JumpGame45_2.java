package leetcode41;

public class JumpGame45_2 {
    public static void main(String[] args)  {
        //int[] nums = {2,3,1,1,4};//1,3,2
        //int [] nums = {1,2,3};
        //int[]nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int[]nums = {2,0};
        JumpGame45_2 p = new JumpGame45_2();

        System.out.println(p.jump2(nums));


        System.out.println(p.canJump(nums));
    }
    public int jump(int[] nums) {
        if(nums.length==0||nums.length==1)return 0;
        int step = 0;
        int maxPre = 0;
        for (int i = 0; i < nums.length; i++) {
            if( (i+nums[i])>maxPre){
                maxPre = i+nums[i];
                step++;
            }
            if(maxPre>=nums.length-1)break;
        }
        return step;

    }
    public int jump2(int[] nums) {
        if(nums.length<2)return 0;
        int step = 0;

        for (int i = 0; i < nums.length; ) {
            if(i+nums[i]>=nums.length-1)break;
            int max = 0;
            int maxIndex = 0;
            for (int j = i+1; j < i+nums[i]+1; j++) {
                if(j+nums[j]>max){
                    max = j+nums[j];
                    maxIndex = j;
                }
            }
            i = maxIndex;
            step++;

        }
        return ++step;

    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i],currentSum+nums[i]);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
    public boolean canJump(int[] nums) {
        return jumpNext(0,nums);
    }
    public boolean jumpNext(int i,int[] nums){
        if(i>=nums.length-1) return true;
        if(nums[i]==0) return false;

        int maxRemote = 0;

        for(int j = 0; j < nums.length; j++){
            if(j+nums[j]>maxRemote) maxRemote = j+nums[j];
            if(maxRemote>=nums.length-1)return true;
        }
        return false;
    }

}
