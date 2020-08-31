package leetcode11;

public class RemoveNthNodeOfList19 {
    public static void main(String[] args){
        RemoveNthNodeOfList19 p = new RemoveNthNodeOfList19();
        int [] array = {2};
        ListNode listNode = new ListNode(1);
        ListNode pindex = listNode;
//        for (int i:array) {
//            pindex.next = new ListNode(i);
//            pindex = pindex.next;
//        }
        p.removeNthFromEnd(listNode,2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nNode = head;
        ListNode index = head;
        //要多走一个
        for (int i = 0; i < n+1; i++) {
            if(index !=null)index=index.next;
            else {//处理当要铲除头结点的情况
                head = head.next;
                break;
            }
        }
        while (index!=null){
            index= index.next;
            nNode = nNode.next;
        }
        if(nNode.next!=null){
            nNode.next = nNode.next.next;
        }else nNode.next = null;
        return head;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null)return l2;
        else if (l2 == null )return l1;
        ListNode head = new ListNode(0);

        ListNode rail = head;
        while(null != l1&& null != l2){
            if(l1.val<l2.val){
                rail.next = l1;
                l1= l1.next;
            }else{
                rail.next = l2;
                l2= l2.next;
            }
            rail = rail.next;
        }
        if(l1==null)rail.next = l2;
        else rail.next = l1;
        return head.next;
    }
}
class ListNode {
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
}