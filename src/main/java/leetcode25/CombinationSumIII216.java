package leetcode25;

import java.util.*;

public class CombinationSumIII216 {
    public static void main(String[] args){
        CombinationSumIII216 p = new CombinationSumIII216();

        System.out.println(p.combinationSum3(3,9));

    }
    private List<Integer> stack = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,0,n,k,0);
        return result;
    }
    private void dfs(int i,int sum, int target,int k,int count){
        if(sum == target && k== count){
            result.add(new ArrayList<>(stack));
            return;
        }
        if(sum>target || count>k)return;

        for (int j = i; j < 10; j++) {
            sum +=j;
            if(sum<=target){
                stack.add(j);
                dfs(j+1,sum,target,k,count+1);
                stack.remove(stack.size()-1);
            }
            else return;
            sum -=j;
        }
    }
}
