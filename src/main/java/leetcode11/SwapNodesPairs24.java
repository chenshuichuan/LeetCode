package leetcode11;

public class SwapNodesPairs24 {
    public static void main(String[] args){
        SwapNodesPairs24 p = new SwapNodesPairs24();
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 2; i < 5; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        head = p.swapPairs(head);

        while (head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        swapLastTwo(myHead);
        return myHead.next;
    }
    public void swapLastTwo(ListNode head) {
        if(head.next == null||head.next.next == null)return ;

        ListNode first = head.next;
        head.next = first.next;
        first.next = head.next.next;
        head.next.next = first;

        swapLastTwo(first);
    }
}
