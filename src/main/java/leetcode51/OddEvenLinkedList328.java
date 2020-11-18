package leetcode51;

public class OddEvenLinkedList328 {

    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode p1 = head;
        ListNode p11 = head;
        ListNode p2 = head.next;
        ListNode p22 = head.next;
        head = head.next.next;
        p1.next=null;
        p2.next=null;
        int i=0;
        while(head!=null){
            ListNode temp =head;
            head= head.next;
            temp.next=null;
            if(i%2==0){
                p11.next=temp;
                p11 = p11.next;
            }else{
                p22.next=temp;
                p22 = p22.next;
            }
            i++;
        }
        p11.next = p2;
        head = p1;
        return head;

    }
}
