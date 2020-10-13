package leetcode41;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PopulatingRightPointersInBT117 {

    public static void main(String[] args)  {
        //int[] nums = {2,3,1,1,4};//1,3,2

        int[]nums = {1,2,3,4,5,0,7};
        PopulatingRightPointersInBT117 p = new PopulatingRightPointersInBT117();
        Node root = Node.buildTree(nums);
        //TreeOperation.show(root);
        root = p.connect(root);
        System.out.println(root.val);
    }
    public Node connect(Node root) {
        return bfs(root);
    }
    private Node bfs(Node root){
        if(root==null)return root;
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);
        nodes.offer(new Node(Integer.MIN_VALUE));
        Node preNode = null;
        while (!nodes.isEmpty()){
            Node temp = nodes.poll();

            //最后一层已处理完
            if(temp.val == Integer.MIN_VALUE && nodes.isEmpty())break;
            //另一层将要开始
            if(temp.val == Integer.MIN_VALUE){
                preNode = null;
                nodes.offer(temp);
                continue;
            }
            if(temp.right!=null)nodes.offer(temp.right);
            if(temp.left!=null)nodes.offer(temp.left);
            temp.next = preNode;
            preNode = temp;

        }

        return root;
    }


}
