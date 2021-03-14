package leetcode61;

import java.util.Stack;

public class VerifyPreorderOfBTree331 {
    public static void main(String[] args) {
        VerifyPreorderOfBTree331 p = new VerifyPreorderOfBTree331();
        String[] strs = {"9,3,4,#,#,1,#,#,2,#,6,#,#","1,#","9,#,#,1"};
        boolean[] results = {true,false,false};

        for (int i = 0; i < strs.length; i++) {
            boolean res =  p.isValidSerialization(strs[i]);
            if(res == results[i]) System.out.println("pass");
            else System.out.println("fail");
        }
    }
    /**
     * 验证字符串是否为二叉树的前序遍历
     * 自底向上，将底部的x,#,# 变为#，无法变更则返回false
     * 栈：从左往右遍历 处理
     * 从右往左处理行不行？
     * */
    public boolean isValidSerialization(String preorder) {
        Stack<String> cSatck = new Stack<>();
        String[] spl = preorder.split(",");

        for (int i = 0; i < spl.length; i++) {
            String c = spl[i];
            if("#".equals(c)){
                while (!cSatck.empty() && "#".equals(cSatck.peek())){
                    cSatck.pop();
                    if(!cSatck.empty()){
                        if("#".equals(cSatck.peek()))return false;
                        else cSatck.pop();
                    }
                }
                if(cSatck.empty()){
                    if(i == spl.length-1)return true;
                    else return false;
                }
                cSatck.push(c);
            }else cSatck.push(c);
        }
        return false;
    }
}
