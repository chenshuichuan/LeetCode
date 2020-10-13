package leetcode41;

import java.util.*;

public class BinaryTreePostorderTraversal145 {
    public static void main(String[] args)  {
        int[] nums = {1,0,2,0,0,3};

        TreeNode root  = TreeNode.buildTree(nums);
        BinaryTreePostorderTraversal145 p = new BinaryTreePostorderTraversal145();
        TreeOperation.show(root);
        System.out.println(p.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root==null)return list;
        Stack<TreeNode> deque  = new Stack<>();
        //deque.push(root);
        TreeNode preTree = root;
        while (preTree!=null||!deque.empty()){

           if(preTree!=null){
               deque.push(preTree);
               list.addFirst(preTree.val);
               preTree = preTree.right;
           }else{
               TreeNode temp = deque.pop();
               preTree = temp.left;
           }
        }
        return list;
    }
}
