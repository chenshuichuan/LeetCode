package leetcode61;

import java.util.*;

public class BTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        BTreeZigzagLevelOrderTraversal103  p = new BTreeZigzagLevelOrderTraversal103();

        int[] arr = {1,2,3,4,0,0,5};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(p.zigzagLevelOrder(root));
    }
    /**
     * 二叉树的Z字遍历
     * 双队列辅助：一个队列做节点的正常从左往右层序遍历；
     *           另一个做存储该层遍历结果的容器，结果从左往右时，就正向存值，从结果右往左时就反向存值
     * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null)return lists;
        Deque<TreeNode> treeNodeQueue = new LinkedList<>();
        boolean leftToRight = true;
        treeNodeQueue.offerFirst(root);
        while (true){
            TreeNode p;
            Deque<Integer> integerQueue = new LinkedList<>();
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                p = treeNodeQueue.poll();
                if(leftToRight){
                    integerQueue.offerLast(p.val);
                }else{
                    integerQueue.offerFirst(p.val);
                }
                if(p.left!=null)treeNodeQueue.offer(p.left);
                if(p.right!=null)treeNodeQueue.offer(p.right);
            }
            leftToRight = !leftToRight;
            lists.add(new ArrayList<>(integerQueue));
            if(treeNodeQueue.isEmpty())break;
        }
        return lists;
    }

    //387. 字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        if(s.isEmpty())return -1;
        int[] count = new int[26];
        int[] firstIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            count[c]++;
            if(count[c]==1)firstIndex[c] = i;
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if(count[i]==1){
                minIndex = Math.min(firstIndex[i],minIndex);
            }
        }
        if(minIndex==Integer.MAX_VALUE)minIndex = -1;
        return minIndex;
    }
}
