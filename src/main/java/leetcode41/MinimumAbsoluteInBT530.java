package leetcode41;

public class MinimumAbsoluteInBT530 {
    public static void main(String[] args)  {
        int []  str = {1,0,2237,0,0,1278,2777,0,0,0,0,520};
        MinimumAbsoluteInBT530 p = new MinimumAbsoluteInBT530();
        TreeNode root = TreeNode.buildTree(str);
        TreeOperation.show(root);
       System.out.println(p.getMinimumDifference(root));
    }
    private int min = 10000;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        dfs(root,-1);
        return min;
    }
    //左子树返回一个比较大的数 和root 比较
    //右子树传入一个比较小的数和root比较
    private int dfs(TreeNode root,int val){
        if(val>0&&val<root.val){
            if(root.val-val<min)min = root.val-val;
        }
        if(root.left!=null){
            int left = dfs(root.left,val);
            if(root.val-left<min)min = root.val-left;
        }
        if(root.right!=null){
            if(root.right.val-root.val<min)min = root.right.val-root.val;
            return dfs(root.right,root.val);
        }

        return root.val;
    }
}
