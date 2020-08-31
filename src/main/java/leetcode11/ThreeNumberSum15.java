package leetcode11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum15 {
    public static void main(String[] args){
        ThreeNumberSum15 p = new ThreeNumberSum15();
        int[]nums = {-1, 0, 1, 2, -1, -4};
        //int[]nums = {-2,0,1,1,2};
        //int[]nums = {-4,-1,2,-1,-5,2,-4,-1,2,0};
//        List<List<Integer>> lists = p.threeSum(nums);
//        for (List<Integer> integers:lists){
//            System.out.println(integers.toString());
//        }
        //int[] threeNums = {-1,2,1,-4}; 1
       // int[] threeNums = { 1,1,-1,-1,3}; -1
        int[] threeNums ={-1,0,1,1,55};//3
        System.out.println(p.threeSumClosest(threeNums,3));
    }

    public int threeSumClosest(int[] nums, int target)  {
        Arrays.sort(nums);
        int losest = 0;
        int min = 10000;
        for (int i = 0; i < nums.length; i++) {
            if(i>0 &&nums[i]==nums[i-1])continue;
            int j=i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (Math.abs(sum-target)<=min){
                    min = Math.abs(sum-target);
                    losest = sum;
                }
                if(sum < target) j++;
                else k--;
            }
        }
        return losest;
    }
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int losest = 0;
        int min = 10000;
        for (int i = 0; i < nums.length; i++) {
            if(i>0 &&nums[i]==nums[i-1])continue;
            boolean flagj=false;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]==nums[j-1] && flagj) continue;
                flagj =false;
                boolean flagk =false;
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[k]==nums[k-1]&& flagk) continue;
                    flagk =false;
                    int threeSum = nums[i]+nums[j]+nums[k];
                    int temp = Math.abs(target - threeSum);
                    if( temp<min){
                        losest = threeSum;
                        min = temp;
                        flagj =true;
                        flagk = true;
                    }
                }
            }
        }
        return losest;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        //int pre
        for (int i = 0; i < nums.length; i++) {
            if(i>0 &&nums[i]==nums[i-1])continue;
            int j=i+1;
            int k = nums.length-1;
            boolean flagj=false;
            boolean flagk=false;

            while (j<k){
                if(flagj&&nums[j]==nums[j-1]){
                    j++;
                    continue;
                }
                if(flagk&&nums[k]==nums[k-1]){
                    k--;
                    continue;
                }
                flagj=false;
                flagk=false;
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> intList= new ArrayList<Integer>();
                    intList.add(nums[i]);
                    intList.add(nums[j]);
                    intList.add(nums[k]);
                    lists.add(intList);
                    j++;
                    flagj=true;
                    flagk=true;
                }
                else if(sum>0)k--;
                else j++;
            }
        }
        return lists;
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if(i>0 &&nums[i]==nums[i-1])continue;
            boolean flagj=false;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]==nums[j-1] && flagj) continue;
                flagj =false;
                boolean flagk =false;
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[k]==nums[k-1]&& flagk) continue;
                    flagk =false;
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> intList= new ArrayList<Integer>();
                        intList.add(nums[i]);
                        intList.add(nums[j]);
                        intList.add(nums[k]);
                        lists.add(intList);
                        flagj =true;
                        flagk = true;
                    }
                }
            }
        }
        return lists;
    }
}
