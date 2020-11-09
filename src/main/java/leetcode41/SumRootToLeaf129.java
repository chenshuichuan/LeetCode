package leetcode41;

public class SumRootToLeaf129 {
    public static void main(String[] args)  {
        SumRootToLeaf129 p = new SumRootToLeaf129();

        TreeNode root = new TreeNode(4);
        root.left = new  TreeNode(9);
        root.right = new  TreeNode(0);
        root.left.left = new  TreeNode(5);
        root.left.right = new  TreeNode(1);

        System.out.println(p.sumNumbers(root));
    }

    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root!=null)dfs(root,0,0);
        return sum;
    }
    private void dfs(TreeNode root,int tempSum,int x){
        int s = tempSum*10+root.val;
        if(root.left==null&&root.right==null){
            sum+=s;
            return;
        }
        if(root.left!=null){
            dfs(root.left,s,x+1);
        }
        if(root.right!=null){
            dfs(root.right,s,x+1);
        }
    }
}
