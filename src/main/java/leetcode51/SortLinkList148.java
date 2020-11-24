package leetcode51;

public class SortLinkList148 {
    public static void main(String[] args){
        int[] arr = {-1,5,3,4,0};
        //int[] arr = {-1,0,3,4,5};
        ListNode head = ListNode.buildListNode(arr);
        ListNode l2 = ListNode.buildListNode(arr);
        SortLinkList148 p = new SortLinkList148();
        head = p.sortList(head);
        //head = p.merge(head,l2);
        while (head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
    }
    //二分归并排序
    public ListNode sortList(ListNode head) {
        return BSort(head);
    }
    //二分归并排序
    private ListNode BSort(ListNode head){
        if(head==null||head.next==null)return head;
        //快慢指针切分链表
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
            if(fast!=null)fast=fast.next;
        }
        if(slow==null)return head;
        if(slow.next==null){
            slow= head;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode l1 = BSort(head);
        ListNode l2 = BSort(head2);
        return merge(l1,l2);
    }
    //合并两条有序链表
    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode root = new ListNode(0);
        root.next = l1;
        l1= root;
        while(l1.next!=null&&l2!=null){
            if(l1.next.val<l2.val){
                l1= l1.next;
            }else{
                //插入l1节点后一个，即l1和l1.next之间
                ListNode p = l2;
                l2 = l2.next;
                p.next = l1.next;
                l1.next = p;
            }
        }
        if(l1.next==null)l1.next= l2;
        return root.next;
    }
}
