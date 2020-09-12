package leetcode25;

import java.util.*;

public class AverageOfLevelsBinaryTree637 {
    public static void main(String[] args) {
        AverageOfLevelsBinaryTree637 p = new AverageOfLevelsBinaryTree637();
        //int[] nums = {3,9,20,0,0,15,7};
        int[]nums = {2147483647,2147483647,2147483647};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(p.averageOfLevels(root));
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> doubles = new ArrayList<>();
        if(root == null)return doubles;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double sum = 0;
        int count = 0;
        while (!queue.isEmpty()){

        }
        return doubles;
    }
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> doubles = new ArrayList<>();
        if(root == null)return doubles;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(root);
        double sum = 0;
        int count = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                if(count>0){
                    Double d = sum/(double)count;
                    doubles.add(d);
                }
                if(queue.isEmpty())break;
                sum =0;
                count = 0;
                queue.offer(node);
            }
            else {
                sum+=node.val;
                count++;
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }

        return doubles;
    }
}
