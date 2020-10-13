package leetcode41;

public class SpecialArrayWithElements5531 {
    public static void main(String[] args)  {
        int[] nums ={3,5};
        SpecialArrayWithElements5531 p = new SpecialArrayWithElements5531();

        System.out.println(p.specialArray(nums));
    }
    public int specialArray(int[] nums) {
        int count = 0;
        while(true){
            int result = 0;
            for(int i=0;i<nums.length;i++){

                if(nums[i]>=count){
                    result++;
                    if(result>count)break;
                }
            }
            if(result==0)break;
            if(result==count)return result;
            count++;
        }
        return -1;
    }
    public boolean isEvenOddTree(TreeNode root) {



        return true;
    }
}
