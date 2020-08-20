package leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

public class ListToBinaryTree109 {
    public static void main(String[] args){
        ListToBinaryTree109 p = new ListToBinaryTree109();
        int [] array = {-3,0,5,6};
        ListNode listNode = new ListNode(-10);
        ListNode pindex = listNode;
        for (int i:array) {
            pindex.next = new ListNode(i);
            pindex = pindex.next;
        }

        TreeNode root = p.sortedListToBST(listNode);
        p.initTreeVal(listNode,root);
        int i =10;
        i++;
        System.out.println(i);
        p.experiment(listNode,root);
        System.out.println(listNode.val+","+root.val);
    }
    public TreeNode experiment(ListNode head,TreeNode root){
        head = new ListNode(1000);
        root = new TreeNode(10000);
        return root;
    }

    public void initTreeVal(ListNode head,TreeNode root){
        if(head == null || root == null)return;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root !=null || !stack.empty() ){
            while(root !=null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty()){
                root = stack.pop();
                root.val = head.val;
                head = head.next;
                root = root.right;
            }
        }
        return;
    }
    public TreeNode sortedListToBST(ListNode head) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ListNode p = head;
        if(p==null)return null;
        TreeNode root = new TreeNode(-10);
        queue.add(root);
        p = p.next;
        while (null!=p&&!queue.isEmpty()){

            TreeNode temp = queue.poll();
            TreeNode left = new TreeNode(p.val);
            temp.left = left;
            queue.add(left);

            p=p.next;
            if(p!=null){
                TreeNode right = new TreeNode(p.val);
                temp.right = right;
                queue.add(right);
                p=p.next;
            }
        }
        return root;
    }
}
