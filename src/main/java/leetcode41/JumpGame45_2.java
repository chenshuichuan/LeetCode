package leetcode41;

public class JumpGame45_2 {
    public static void main(String[] args)  {
        //int[] nums = {2,3,1,1,4};//1,3,2

        int[]nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        JumpGame45_2 p = new JumpGame45_2();

        System.out.println(p.jump(nums));
    }
    public int jump(int[] nums) {
        if(nums.length==0||nums.length==1)return 0;
        int step = 0;
        int maxPre = 0;
        for (int i = 0; i < nums.length; i++) {
            if( i+nums[i]>maxPre){
                maxPre = i+nums[i];
                step++;
            }
            if(maxPre>=nums.length-1)break;
        }
        return step;

    }
}
