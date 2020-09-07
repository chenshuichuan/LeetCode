package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOTraversal107 {
    public static void main(String[] args){
        BTLevelOTraversal107 p = new BTLevelOTraversal107();
        int[] array= {3,9,20,0,0,15,7};
        TreeNode root = p.BinaryTree(array);
        List<List<Integer>> lists = p.levelOrderBottom(root);
        System.out.println(lists.size());
    }
    public TreeNode BinaryTree(int[]array)
    {
        return createBinaryTreeByArray(array, 0);
    }

    private TreeNode createBinaryTreeByArray(int []array,int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            int value = array[index];
            if(value ==0 )return null;
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }


    private List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        lists.add(new ArrayList<Integer>());
        dfs(0,root);
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        for (int i = lists.size()-1; i >=0 ; i--) {
            if(lists.get(i).size()>0)temp.add(lists.get(i));
        }
        return temp;
    }
    private void dfs(int i,TreeNode root){
        if(root ==null)return;
        if(i>=lists.size()){
            lists.add(new ArrayList<Integer>());
        }
        lists.get(i).add(root.val);
        dfs(i+1,root.left);
        dfs(i+1,root.right);
    }
}
