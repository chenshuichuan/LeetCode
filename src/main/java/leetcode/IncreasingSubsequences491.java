package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//时间复杂度：O(n*2^n)。仍然需要对子序列做二进制枚举，枚举出的序列虽然省去了判断合法性和哈希的过程，
// 但是仍然需要O(n) 的时间添加到答案中。//总是追到 nums.length 才加进结果
//空间复杂度：O(n)。这里临时数组的空间代价是 O(n)，递归使用的栈空间的空间代价也是 O(n)。

public class IncreasingSubsequences491 {
    public static void main(String[] args){
        IncreasingSubsequences491 p = new IncreasingSubsequences491();
        int[]nums = {4,6,7,7};
        int[]nums1 = {4,7,7,5,6};
        int[]nums2 = {4,7,8,9,10};
        System.out.println(p.findSubsequences(nums).toString());
    }
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private List<Integer> temp = new ArrayList<Integer>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0,-101);
        return ans;
    }
    private void dfs(int[] nums, int index,int last){

        if(index>=nums.length){
            if(temp.size()>=2){
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if(nums[index]>=last){
            temp.add(nums[index]);
            dfs(nums,index+1,nums[index]);
            temp.remove(temp.size()-1);
        }
        if(nums[index]!=last){
            dfs(nums,index+1,last);
        }

    }
}
