package leetcode61;

public class ListNode {
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

    public static ListNode buildListNode(int[] arrays){
        ListNode head = new ListNode(1);
        ListNode pindex = head;
        for (int i:arrays) {
            pindex.next = new ListNode(i);
            pindex = pindex.next;
        }
        return head.next;
    }
    public static void printList(ListNode listHead){
        ListNode p = listHead;
        System.out.print("[");
       while(p!=null){
           System.out.print(p.val+",");
           p = p.next;
       }
        System.out.print("]");
    }
}
