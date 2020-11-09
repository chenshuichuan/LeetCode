package leetcode41;

public class PalindromeLinkedList234 {
    public static void main(String[] args)  {
        PalindromeLinkedList234 p = new PalindromeLinkedList234();

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        System.out.println(p.isPalindrome(root));
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode p1=head;
        ListNode p2=head.next;
        int nums= 2;
        //找到中点
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
            nums++;
            if(p2.next!=null){
                p2=p2.next;
                nums++;
            }
            else break;
        }
        ListNode head2=p1.next;
        p1.next=null;

        //翻转后半部分链表
        ListNode temp = head2;
        while (temp.next!=null){
            ListNode p = temp.next;
            temp.next=head2;
            head2=temp;
            temp=p;
        }
        temp.next=head2;
        head2=temp;
        //比较两部分

        for (int i = 0; i < nums / 2; i++) {
            if(head.val!=head2.val)return false;
            head=head.next;
            head2=head2.next;
        }
        return true;
    }
}
