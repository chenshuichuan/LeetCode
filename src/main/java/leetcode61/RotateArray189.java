package leetcode61;

public class RotateArray189 {
    public static void main(String[] args) {
        RotateArray189 p = new RotateArray189();
        int[] nums = {1,2,3,4,5,6};
        p.rotate(nums,2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
    }
    //最佳答案: 两极翻转
    //第一步翻转整个数组
    //然后分别翻转[0,right-1]以及[right,nums.length-1] 的部分，即可完成
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    //旋转数组，先找到右移k之后right的位置，这是关键
    public void rotate3(int[] nums, int k) {
        int right = k%nums.length;
        if(right==0)return;
        //复制填充 nums.length-right-1 nums.length-1
        int[] num = new int[right];
        int ind = nums.length-right;
        for(int i=0;i<right;i++){
            num[i] = nums[i+ind];
        }

        //从0到nums.length-right 集体右移right位
        ind = nums.length-1;
        for(int i=nums.length-right-1;i>=0;i--){
            nums[ind] = nums[i];
            ind--;
        }

        for(int i=0;i<right;i++){
            nums[i] = num[i];
        }
    }
    //旋转数组，先找到右移k之后right的位置，这是关键
    public void rotate2(int[] nums, int k) {
        int right = k%nums.length;
        if(right==0)return;
        //复制填充 0-right-1
        int[] num = new int[right];
        int ind = nums.length-right;
        for(int i=0;i<right;i++){
            num[i] = nums[i];
            nums[i] = nums[ind];
            ind++;
        }
        //从right到nums.length-right 集体右移right位
        ind = nums.length-1;
        for(int i=nums.length-right-1;i>=right;i--){
            nums[ind] = nums[i];
            ind--;
        }
        //num 放回right，right+right
        for(int i=0;i<num.length;i++){
            ind=right+i;
            if(ind>=nums.length)break;
            nums[ind] = num[i];
        }
    }
}
