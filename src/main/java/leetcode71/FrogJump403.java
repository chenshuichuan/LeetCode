package leetcode71;

import java.util.HashSet;
import java.util.Set;

public class FrogJump403 {
    public static void main(String[] agv){
        int [] stones={0,1,3,5,6,8,12,17};

        FrogJump403 p = new FrogJump403();

        System.out.println( p.canCross(stones));

    }

    private Set<Integer> set ;
    public boolean canCross(int[] stones) {
        set =  new HashSet<>();

        for(int i =1;i<stones.length;i++){
            set.add(stones[i]);
        }
        int res = stones[stones.length-1];
        return dfs(0,1,res);
    }
    //深搜，
    private boolean dfs(int curr,int k ,int res){
        if(k<=0)return false;
        curr+=k;
        if(!set.contains(curr))return false;
        if(curr == res)return true;
        if(curr>res)return false;
        return dfs(curr,k-1,res) || dfs(curr,k,res) || dfs(curr,k+1,res);
    }
}
