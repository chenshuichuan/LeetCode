package leetcode25;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static void main(String[] args){
        Combinations77 c = new Combinations77();
        System.out.println(c.combine(4,2).size());
    }
    private List<Integer> stack = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return result;
    }
    private void dfs(int i, int n, int k){
        if(stack.size()+n-i <k)return;
        if(stack.size() == k){
            result.add(new ArrayList<>(stack));
            return;
        }
        if(i>n)return;

        stack.add(i);
        dfs(i+1,n,k);
        stack.remove(stack.size()-1);
        dfs(i+1,n,k);
    }


    public int removeDuplicates(int[] nums,int val) {
        int j = 0;
        int i =0;
        while(j<nums.length){
            if(val!=nums[j]){
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
