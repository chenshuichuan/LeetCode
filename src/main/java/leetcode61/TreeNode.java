package leetcode61;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode buildTree(int[]array){
        return createBinaryTreeByArray(array, 0);
    }

    private static TreeNode createBinaryTreeByArray(int []array, int index)
    {
        TreeNode tn = null;
        if (index<array.length) {
            int value = array[index];
            if(value == 0)return null;
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }
    public static void printTree(TreeNode root){
        print(root,1);
    }
    private static void print(TreeNode root, int n){
        if(root==null)return;
        print(root.left,n+1);
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
        System.out.println("--"+root.val);
        print(root.right,n+1);
    }
}