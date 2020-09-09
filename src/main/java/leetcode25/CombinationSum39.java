package leetcode25;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args){
        CombinationSum39 c = new CombinationSum39();
        int[] ca = {2,3,6,7};
        System.out.println(c.combinationSum(ca,7).size());
    }
    private List<Integer> stack = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,candidates,target,0);
        return result;
    }
    private void dfs(int i, int[] candidates, int target,int sum){
        if(sum>target || i>=candidates.length)return;
        if(sum == target){
            result.add(new ArrayList<>(stack));
            return;
        }
        stack.add(candidates[i]);
        sum +=candidates[i];
        dfs(i,candidates,target,sum);
        stack.remove(stack.size()-1);
        sum -=candidates[i];
        dfs(i+1,candidates,target,sum);
    }

    private void dfs2(int i, int[] candidates, int target,int sum){
        if(sum>target || i>=candidates.length)return;
        if(sum == target){
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            stack.add(candidates[j]);
            sum +=candidates[j];
            dfs(j,candidates,target,sum);
            stack.remove(stack.size()-1);
            sum -=candidates[j];
        }
    }
}
