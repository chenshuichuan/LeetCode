package leetcode41;

import java.util.Arrays;
import java.util.BitSet;

public class FirstMissingPositive41 {
    public static void main(String[] args) {

//        System.out.println(1<<3);//8 0001 << 1000
//        System.out.println(1>>3);//0 0001 >> 0000 001
//        System.out.println(3<<1);//6 0011 << 0110
//        System.out.println(3>>1);//1 0011 >> 0001 1
        //System.out.println(1<<0);

        FirstMissingPositive41 p = new FirstMissingPositive41();
        //int[]nums = {1,2,3};
        //int[]nums = {1,2,0};
        //int[]nums = {100000,1000002,-1,1};
        int[]nums= {0,-1,3,1};
        System.out.println(p.firstMissingPositive(nums));;
    }
    public int firstMissingPositive(int[] nums) {
        int n1Flag = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0||nums[i]>nums.length)continue;
            if(nums[i] == nums.length){
                n1Flag = nums.length;
                continue;
            }
            while (nums[nums[i]]!=nums[i]){
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
                if(nums[i]<0||nums[i]>nums.length)break;
                if(nums[i] == nums.length){
                    n1Flag = nums.length;
                    break;
                }
            }
        }
        int i=1;
        for ( ; i < nums.length; i++) {
            if(nums[i]!=i)return i;
        }
        if(i == nums.length && n1Flag==nums.length)return i+1;
       return i;
    }

    public int firstMissingPositive2(int[] nums) {

        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)flag |= 1<<(nums[i]-1);
            System.out.println(Integer.toBinaryString(flag));
        }
        String str = Integer.toBinaryString(flag);
        System.out.println(str);
        for (int i =str.length()-1; i >=0; i--) {
            if(str.charAt(i) == '0')return str.length()-i;
        }
        return str.length()+1;
    }
}
