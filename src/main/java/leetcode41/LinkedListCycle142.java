package leetcode41;

public class LinkedListCycle142 {
    public static void main(String[] args)  {

        LinkedListCycle142 p = new LinkedListCycle142();
        ListNode n1 = new ListNode(3);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(0);
        n1.next.next.next = new ListNode(-4);
        n1.next.next.next.next = n1.next;
        System.out.println(p.detectCycle(n1).val);
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode p0= head;
        ListNode p1= head;
        while(true){

            p0=p0.next;
            if(p1.next!=null)p1=p1.next.next;
            else {
                p1=p1.next;
                break;
            }
            if(p1==null||p0.val==p1.val)break;
        }
        if(p1==null)return null;
        ListNode pp = head;
        while(pp.val!=p0.val){
            pp=pp.next;
            p0=p0.next;
        }
        return pp;
    }
}
