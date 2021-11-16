package leetcode71;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public static void main(String[] args){
        String[]tokens = {"4","13","5","/","+"};
        EvaluateReversePolishNotation150 p = new EvaluateReversePolishNotation150();
        System.out.println(p.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if(str.length()==1){
                if("+".equals(str)){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(cal(num1,num2,str));
                }
                else if("-".equals(str)){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(cal(num1,num2,str));
                }
                else if("*".equals(str)){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(cal(num1,num2,str));
                }
                else if("/".equals(str)){
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(cal(num1,num2,str));
                }else stack.push(Integer.parseInt(str));
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    private int cal(int num1,int num2, String op){
        if("+".equals(op)){
            return num1+num2;
        }
        else if("-".equals(op)){
            return num1-num2;
        }
        else if("*".equals(op)){
            return num1*num2;
        }else return num1/num2;
    }
}
