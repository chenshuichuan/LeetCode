package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    public static void main(String[] args){

    }
    private List<String> stringList = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root,str);
        return stringList;
    }
    private void dfs(TreeNode root,StringBuilder str){
        if (root == null)return;
        str.append(root.val);
        if(root.left == null && root.right ==null){
            stringList.add(str.toString());
        }
        dfs(root.left,new StringBuilder(str).append("->"));
        dfs(root.right,new StringBuilder(str).append("->"));
    }


}

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
}
