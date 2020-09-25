package leetcode41;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInPost106 {

    public static void main(String[] args)  {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

//        int[] inorder = {2,3,1};
//        int[] postorder = {3,2,1};

        ConstructBinaryTreeInPost106 p = new ConstructBinaryTreeInPost106();
        TreeNode root = p.buildTree(inorder,postorder);
        TreeOperation.show(root);
    }
    private Map<Integer,Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length==0||postorder.length==0)return null;
        for (int i = 0; i <inorder.length ; i++) {
            hashMap.put(inorder[i],i);
        }
        return dfs(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    private TreeNode dfs(int[] inorder, int[] postorder,int iStart,int iEnd,int pStart,int pEnd){
        if(iStart>iEnd || pStart>pEnd)return null;
        if(iStart<0||pStart<0 ||iEnd>=inorder.length||pEnd>=postorder.length)return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        int i = hashMap.get(postorder[pEnd]);
        //左子树个数
        int size = i-1-iStart;
        //划分左右子树
        root.left = dfs(inorder,postorder,iStart,i-1,pStart,pStart+size);
        root.right = dfs(inorder,postorder,i+1,iEnd,pStart+size+1,pEnd-1);
        return root;
    }
}
