package leetcode41;

public class BinaryTreeCameras968 {
    public static void main(String[] args) {
        BinaryTreeCameras968 p = new BinaryTreeCameras968();

        //int[] array = {1,1,0,1,1};
        //int[] array = {1,1,0,1,0,1,0,0,1};
        //[0,0,null,null,0,0,null,null,0,0]
        //int[]array = {1,1,0,0,1,1,0,0,1,1};
        //[0,0,null,0,0,0,null,null,0]
        int[]array={1,1,0,1,1,1,0,0,1};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(p.minCameraCover(root));
        //TreeNode.printTree(root);
        TreeOperation.show(root);
    }
    private int sum = 0;
    public int minCameraCover(TreeNode root) {
        if(root==null)return 0;
        int i = dfs(root);
        if(i==2)return sum+1;
        return sum;
    }
    private int dfs(TreeNode root){
        if(root==null)return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left==2||right==2){
            sum++;
            return 0;
        }
        return left>right?right+1:left+1;
    }
}
