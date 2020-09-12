package leetcode25;

import java.util.Arrays;
//2,4,3,1
//1,3,5,6,7,4,2
//4,5,6,7,3,2,1

//4,1,3,2
//4,2,3,1

//1,2,3,7,8,9,6,5,4
//1.找到交界点i,和i-1;
//2.从i到size 找到一个比i-1大的最小的min，进行交换
public class NextPermutation31 {
    public static void main(String[] args){
        NextPermutation31 p = new NextPermutation31();
        int[]nums = {5,4,7,5,3,2};
        //[5,5,2,3,4,7]
        p.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        int[]nums2 = {1,2,3,7,8,9,6,5,4};
        p.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2));
        int[]nums3 = {1,3,2};
        p.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3));

    }
    public void nextPermutation(int[] nums) {
        if(nums.length==0)return;
        boolean shouldReverse= true;

        for (int i = nums.length-1; i >0 ; i--) {
            //该交换时,找到交界点i,和i-1;
            if(nums[i-1]<nums[i]){
                //从i到size 找到一个比i-1大的最小的min
                int min = i;
                int j = i+1;
                for (; j < nums.length; j++) {
                    if(nums[j]<=nums[i-1]) break;
                    min = j;
                }
                int tempMin = nums[min];
                nums[min] = nums[i-1];
                nums[i-1] = tempMin;

                //从i到size 倒一遍
                int len = (nums.length-i)/2;
                for (int k = 0; k <len; k++) {
                    int temp = nums[i+k];
                    nums[i+k] = nums[nums.length-1-k];
                    nums[nums.length-1-k] = temp;
                }
                shouldReverse = false;
                break;
            }
        }
        //未找到交换，则说明数组是从高到低的排序
        if(shouldReverse){
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length-i-1];
                nums[nums.length-i-1] = temp;
            }
        }
    }
}
