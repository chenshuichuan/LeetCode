package leetcode61;

public class PartitionList86 {
    public static void main(String[] args) {
        PartitionList86 p = new PartitionList86();
        int[][] arr = {{},{1,4,3,2,5,2}};
        int[] xs = {1,3};
        for (int i = 0; i < arr.length; i++) {
            ListNode head = ListNode.buildListNode(arr[i]);
            head = p.partition(head,xs[i]);
            ListNode.printList(head);
        }
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next == null)return head;
        ListNode root = new ListNode();
        root.next = head;
        ListNode p = root;
        //找到插入位置
        while(p.next!=null && p.next.val<x)p=p.next;
        //遍历后半部分
        ListNode iter = p;
        while(iter.next !=null){
            if(iter.next.val<x){
                //断开iter.next节点,接在p后面
                ListNode temp = iter.next;
                iter.next = iter.next.next;

                temp.next = p.next;
                p.next = temp;
                p = p.next;
            }
            else {
                iter = iter.next;
            }
        }
        return root.next;
    }
}
