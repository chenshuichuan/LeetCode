package leetcode41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class FindModeBinarySearchTree501 {
    public static void main(String[] args)  {
        FindModeBinarySearchTree501 p = new FindModeBinarySearchTree501();

        int[] nums = {1,0,2,0,0,2,0};
        TreeNode root = TreeNode.buildTree(nums);
        int[] array = p.findMode(root);

        System.out.println(Arrays.toString(array));
    }
    private List<Integer> list = new ArrayList<>();
    private int count = 0;
    private int preCount = -1;
    private int index = MIN_VALUE;
    public int[] findMode(TreeNode root) {
        dfs(root);
        if(count>=preCount){
            if(count>preCount)list.clear();
            list.add(index);
        }
        int []array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    private void dfs(TreeNode root){

        if(root==null)return;

        dfs(root.left);
        if(index!=root.val){
            if(count>=preCount){
                if(count>preCount)list.clear();
                if(count>0)list.add(index);
                preCount = count;
            }
            count = 1;
            index = root.val;
        }
        else count++;
        dfs(root.right);
    }
}
