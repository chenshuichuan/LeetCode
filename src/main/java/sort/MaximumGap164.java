package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumGap164 {
    public static void main(String[] args){
        MaximumGap164 p = new MaximumGap164();
        int[] nums = {1,3,6,9,1};//3,6,9,1
        System.out.println(p.maximumGap(nums));

    }
    //寻找间隔最大
    public int maximumGap(int[] nums) {
        nums = radixSort(nums);
        //寻找最大间隔
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int gap = nums[i]-nums[i-1];
            if(gap>max) max = gap;
        }
        return max;
    }
    //正负数通用的基数排序
    public int[] radixSort(int[] nums){
        if(nums==null||nums.length<=1)return nums;
        int maxLength = 0;
        int l;
        for (int i = 0; i < nums.length; i++) {
             if(nums[i]>0)l= String.valueOf(nums[i]).length();
             else l= String.valueOf(-nums[i]).length();
             if(l>maxLength) maxLength = l;
        }

        int p = 10;
        //未完全实现，正负数通用要求19个桶0-9装负数,10-19装正数
        List<List<Integer>> lists = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>());
        }
        while (maxLength>0){
            maxLength--;
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i];
                if(p>1)index = (index/(p/10))%10;
                lists.get(index).add(nums[i]);
            }
            p=p*10;
            int index = 0;
            for (int i = 0; i < lists.size(); i++) {
                for (Integer num:lists.get(i)) {
                    nums[index++] = num;
                }
            }
            for (int i = 0; i < 10; i++) {
                lists.get(i).clear();
            }
        }
        return nums;
    }

    public int[] radixSort2(int[] nums){
        if(nums==null||nums.length<=1)return nums;
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>maxNum) maxNum = nums[i];
        }
        int n = 0;
        while (maxNum!=0){
            //System.out.println("n="+n+",maxNum="+maxNum);
            n++;
            maxNum=maxNum/10;
        }

        int p = 10;
        while (n>0){
            n--;
            List<List<Integer>> lists = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                lists.add(new ArrayList<>());
            }
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i];
                if(p>1)index = (index/(p/10))%10;
                lists.get(index).add(nums[i]);
            }
            p=p*10;
            int index = 0;
            for (int i = 0; i < lists.size(); i++) {
                for (Integer num:lists.get(i)) {
                    nums[index++] = num;
                }
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]+",");
//        }
        return nums;
    }
}
