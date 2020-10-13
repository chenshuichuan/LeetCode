package leetcode41;

import java.util.ArrayList;
import java.util.List;

public class PathSumInBTree113 {
    public static void main(String[] args)  {
        //int[] height = {-2,0,-3};
        int[] height = {1,-2,-3,1,3,-2,0,-1};
        PathSumInBTree113 p = new PathSumInBTree113();
        TreeNode root = TreeNode.buildTree(height);
        TreeOperation.show(root);
        List<List<Integer>> lists = p.pathSum(root,-1);
        System.out.println(lists);
    }
    private List<List<Integer>> lists = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root!=null)dfs(root,sum,0);
        return lists;
    }
    private void dfs(TreeNode root, int sum,int count){
        //if(sum<root.val)return;
        list.add(root.val);
        count+=root.val;
        if(sum==count && root.left==null && root.right==null){
            lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(root.left!=null)dfs(root.left,sum,count);
        if(root.right!=null)dfs(root.right,sum,count);

        list.remove(list.size()-1);
    }
}
