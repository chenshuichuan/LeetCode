package leetcode;

public class MinimumDepthBinaryTree111 {

    public static void main(String[] args){
        MinimumDepthBinaryTree111 p = new MinimumDepthBinaryTree111();
        int [] array = {1,2};
        TreeNode listNode = new TreeNode(-10);
        listNode.left = new TreeNode(2);
        System.out.println(p.minDepth(listNode));
        System.out.println(listNode.val+",");
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return next(root);
    }
    public int next(TreeNode root){
        if(root.left == null && root.right == null) return 1;
        int left = 0;
        int right =0;
        if(root.left!=null )left = next(root.left);
        if(root.right!=null )right =next(root.right);
        if(left>0&&right>0) return left<=right?left+1:right+1;
        else return left+right+1;
    }
}
