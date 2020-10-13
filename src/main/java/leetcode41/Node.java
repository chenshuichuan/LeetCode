package leetcode41;

public class Node  {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public static Node buildTree(int[]array){
        return createBinaryTreeByArray(array, 0);
    }

    private static Node createBinaryTreeByArray(int []array, int index)
    {
        Node tn = null;
        if (index<array.length) {
            int value = array[index];
            if(value == 0)return null;
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
