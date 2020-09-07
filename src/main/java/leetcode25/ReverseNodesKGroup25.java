package leetcode25;

import java.util.List;

public class ReverseNodesKGroup25 {
    public static void main(String[] args){
        ReverseNodesKGroup25 p = new ReverseNodesKGroup25();
        int[]arrays = {1,2,3,4,5};
        ListNode listNode = ListNode.buildListNode(arrays);
        ListNode head = p.reverseKGroup(listNode,3);

        System.out.println(head.val);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head ==null ||head.next ==null||k ==1)return head;

        ListNode root = null;
        ListNode mid = head;//每段的原头
        ListNode pre = head;
        int i=0;
        while (head!=null){
            i++;
            if(i==k){
                i=0;//置零
                ListNode tou = head;
                head = head.next;
                tou.next = null;//断开前面K个,然后翻转前面K个
                ListNode[] listNodes = reverseAll(mid);
                mid = head;
                if(root==null) root = listNodes[1];
                else pre.next = listNodes[1];
                pre = listNodes[0];
            }
            else{
                head = head.next;
            }
        }
        pre.next = mid;
        return root;
    }
    //返回反转后的头和尾
    public ListNode[] reverseAll(ListNode head){
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = head;
        ListNode pre = head;
        ListNode mid = head.next;
        head = head.next.next;
        pre.next = null;
        while (head!=null){
            mid.next = pre;
            pre = mid;
            mid = head;
            head= head.next;
        }
        mid.next = pre;
        listNodes[1] = mid;
        return listNodes;
    }

}
