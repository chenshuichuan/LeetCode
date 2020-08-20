package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindTheTwoAddNumber {
    public static void main(String[] args){
        StringMulti stringMulti = new StringMulti();

    }
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
            //因为有且只有一对/或要求只找一对，那存入hash中有总有一个先一个后，
            // 一次遍历
            // 所以可以一边存入一个数，一边检查是否已经有匹配的数存在于hash中了，，这时，可以存target-nums[i],那么到nums[j]检查nums[j]是否已经存于hash中
        }
        for (int i = 0; i < nums.length; i++) {
            int result = target-nums[i];
            //实际上是检查另一个数(result)在数组中的哪里
            if(hashMap.containsKey(result)){
                if(hashMap.get(result)!=i){
                    return new int[]{i,hashMap.get(result)};
                }
                //else //是自己本身的情况 如8=4+4/10=5+5 一遍hash 就是
            }
        }
        return null;
    }
}
