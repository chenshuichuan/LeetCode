package leetcode41;

import java.util.Arrays;

public class ConvertBstToGreaterTree538 {

    public static void main(String[] args) {
        ConvertBstToGreaterTree538 p = new ConvertBstToGreaterTree538();
//        int[] array = {5,2,13};
//        TreeNode root = TreeNode.buildTree(array);
//        p.convertBST(root);
//        System.out.println(root.val);

        //[2,0,3,-4,1]  [5,6,3,2,6]
        TreeNode root = new TreeNode(2) ;
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);
        p.convertBST(root);
        System.out.println(root.val);
    }
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    private void dfs(TreeNode root){
        if (root==null)return;

        dfs(root.right);
        sum+=root.val;
        root.val = sum;
        dfs(root.left);
    }
}
