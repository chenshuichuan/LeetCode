package sort;

import java.util.Arrays;

public class LastStoneWeight1046 {
    public static void main(String[] args) {

        LastStoneWeight1046 p = new LastStoneWeight1046();
        //1,2,0,3
        int[][] numsList = {{2,7,4,1,8,1}};

        for (int i = 0; i < numsList.length; i++) {
            System.out.println(p.lastStoneWeight(numsList[i]));
        }
    }
    //两两相消，最后一块石头的重量
    //先排序，拿最大的两个两两相消，结果插入回有序数组，
    public int lastStoneWeight(int[] stones) {
        //Arrays.sort(stones);
        stones = insertSort(stones);
        int last = stones.length-1;
        int res=0;
        while(last>0){
            res = Math.abs(stones[last]-stones[last-1]);
            last--;
            if(res!=0){
                int i = last;//i待插入位置
                while (i>0 && stones[i-1]>res){
                    stones[i]=stones[i-1];
                    i--;
                }
                stones[i] = res;
            }else last--;
        }
        return last==0?stones[last]:res;
    }
    //插入排序
    public int[] insertSort(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            int temp  = nums[i];
            int j = i;
            while (j>0 && nums[j-1]>temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i]+",");
//        }
        return nums;
    }
}
