package leetcode51;

import java.util.Stack;

public class RemoveKDigits402 {
    class ListNode {
        int val;
        ListNode next;
        ListNode pre;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args){
        RemoveKDigits402 p = new RemoveKDigits402();
        System.out.println(p.removeKdigits("10200",1));
    }
    public String removeKdigits(String num, int k) {
        if(k>=num.length())return "0";
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 0; i < num.length(); i++) {
            temp.next = new ListNode(num.charAt(i)-48);
            temp.next.pre= temp;
            temp = temp.next;
        }
        //从左往右比较，左边比右边大，则左边需要剔除
        temp = head;
        //head.next才是开始
        while (temp.next!=null&&temp.next.next!=null&&k>0){
            if(temp.next.val>temp.next.next.val){
                temp.next.next.pre = temp.next.pre;
                temp.next = temp.next.next;
                k--;
                //回退前一个进行比较
                if(temp.pre==null)continue;
                ListNode pre = temp.pre;
                while (k>0&&pre.next.val>pre.next.next.val){
                    pre.next.next.pre = pre.next.pre;
                    pre.next = pre.next.next;
                    k--;
                    if(pre.pre==null)break;
                    pre = pre.pre;
                }
                temp = pre.next;

            }else temp = temp.next;
        }
        //如果k没去除完，从尾部开始剔除，因为此时尾部最大，stack是从顶至下递减的；
        //双指针
        temp = head;
        ListNode temp2= head;
        while (k>0){
            temp2 = temp2.next;
            k--;
        }
        StringBuilder str = new StringBuilder();
        //构建str
        boolean zero = false;
        if(temp.next.val ==0)zero = true;
        while (temp2.next!=null){
            temp2 = temp2.next;
            temp = temp.next;
            //去头部的0
            if(zero&&temp.val==0)continue;
            else zero = false;
            str.append(temp.val);
        }
        if (str.length()==0)return "0";
        return str.toString();
    }
    public String removeKdigits2(String num, int k) {
        if(k==num.length())return "0";
        char[] s = num.toCharArray();
        Stack<Character> cStack = new Stack<>();
        cStack.push(s[0]);
        //从左往右比较，左边比右边大，则左边需要剔除
        for (int i = 1; i < s.length; i++) {
            while(!cStack.empty()&&k>0&&s[i]<cStack.peek()){
                cStack.pop();
                k--;
            }
            //如果左边没有了，左边的0也不需要放进去了
            if(cStack.isEmpty()&&s[i]=='0'){
                continue;
            }
            cStack.push(s[i]);
        }
        //如果k没去除完，从尾部开始剔除，因为此时尾部最大，stack是从顶至下递减的；
        while (k>0){
            cStack.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        //构建str//并且翻转
        while (!cStack.empty())str.append(cStack.pop());
        if (str.length()==0)return "0";
        return str.reverse().toString();
    }
}
