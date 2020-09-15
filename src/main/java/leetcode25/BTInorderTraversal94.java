package leetcode25;

import java.util.*;

public class BTInorderTraversal94 {
    public static void main(String[] args) {
        int[]nums = {1,0,2,0,0,3};
        TreeNode root = TreeNode.buildTree(nums);
        BTInorderTraversal94 p = new BTInorderTraversal94();
        System.out.println(p.inorderTraversal(root).size());
    }
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root= root.right;
        }
        return list;
    }
    public List<Integer> inorderTraversal2(TreeNode root) {
        inorder(root);
        return list;
    }
    private void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
