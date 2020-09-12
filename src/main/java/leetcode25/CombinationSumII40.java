package leetcode25;

import java.util.*;

public class CombinationSumII40 {
    public static void main(String[] args){
        CombinationSumII40 c = new CombinationSumII40();
        //int[] ca = {10,1,2,7,6,1,5};
        //System.out.println(c.combinationSum2(ca,8).size());

        int[]ca2 = {2,5,2,1,2};
        System.out.println(c.combinationSum2(ca2,5));
    }
    private List<Integer> stack = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    private Map<String,Integer> map = new HashMap<>();
    private StringBuilder builder = new StringBuilder();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,candidates,target,0);
        return result;
    }
    private void dfs(int i, int[] candidates, int target,int sum){
        if(sum == target){
            if(map.containsKey(builder.toString()))return;
            map.put(builder.toString(),0);
            result.add(new ArrayList<>(stack));
            return;
        }
        if(sum>target || i>=candidates.length)return;

        for (int j = i; j < candidates.length; j++) {
            sum +=candidates[j];
            if(sum<=target){
                stack.add(candidates[j]);
                builder.append(candidates[j]);
                dfs(j+1,candidates,target,sum);
                stack.remove(stack.size()-1);
                builder.replace(builder.length()-String.valueOf(candidates[j]).length(),builder.length(),"");
            }
            else return;
            sum -=candidates[j];
        }
    }

}
