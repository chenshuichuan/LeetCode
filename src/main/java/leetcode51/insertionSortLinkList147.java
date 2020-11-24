package leetcode51;

public class insertionSortLinkList147 {
    public static void main(String[] args){
        insertionSortLinkList147 p = new insertionSortLinkList147();
        int[]arr = {4,2,1,3};
        ListNode head = ListNode.buildListNode(arr);
        head = p.insertionSortList(head);
        while (head!=null) {
            System.out.println(head.val);
            head=head.next;
        }

    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null)return null;
        ListNode root = new ListNode();
        root.next = head;
        ListNode p = head;
        while(p.next!=null){
            //找到待排节点
            if(p.next.val<p.val){
                //断开节点
                ListNode temp = p.next;
                p.next = p.next.next;
                //找到插入位置
                ListNode i=root;
                while(i.next!=null){
                    if(i.next.val>temp.val){
                        temp.next=i.next;
                        i.next = temp;
                        break;
                    }
                    i=i.next;
                }
            }
            else p=p.next;
        }
        return root.next;
    }
}
