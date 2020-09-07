package leetcode25;

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
}
