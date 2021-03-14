package leetcode61;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator224 {
    public static void main(String[] args) {
        String[] strs = {"(1+(4+5+2)-3)+(6+8)","(7)-(0)+(4)","- (3 + (4 + 5))"};
        BasicCalculator224 p = new BasicCalculator224();
        for (String string : strs) {
            System.out.println(p.calculate(string));
        }
    }
    /**
     * 简易计算器：(1+(4+5+2)-3)+(6+8)
     * 遍历字符串，
     * */
    public int calculate(String s) {
        Stack<Character> opDeque = new Stack<>();
        Stack<Integer> numDeque = new Stack<>();
        // 将所有的空格去掉，并将 (- 替换为 (0-
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        if(s.charAt(0) == '-')numDeque.push(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isNumber(c)){
                int start = i;
                i++;
                while (i < s.length() && isNumber((s.charAt(i))))i++;
                int num2 = Integer.parseInt(s.substring(start,i));
                if(!opDeque.empty() && !numDeque.empty() && opDeque.peek()!='('){
                    int num1 = numDeque.pop();
                    char op = opDeque.pop();
                    int result = cal(num1,num2,op);
                    numDeque.push(result);
                }else numDeque.push(num2);

            }
            if(i<s.length()){
                c = s.charAt(i);
                if(c == ')' ){
                    //遇到)要把op算到(
                    while (opDeque.peek() !='('){
                        int num2 = numDeque.pop();
                        int num1 = numDeque.pop();
                        char op = opDeque.pop();
                        int result = cal(num1,num2,op);
                        numDeque.push(result);
                    }
                    opDeque.pop();
                }
                if(c == '(' )opDeque.push(c);
                //新操作符入栈也要把能算的都算完
                if( c =='+' || c=='-' ){
                    while (!opDeque.empty() && opDeque.peek()!='('){
                        int num2 = numDeque.pop();
                        int num1 = numDeque.pop();
                        char op = opDeque.pop();
                        int result = cal(num1,num2,op);
                        numDeque.push(result);
                    }
                    opDeque.push(c);
                }
            }
        }
        while (!opDeque.empty()){
            int num2 = numDeque.pop();
            int num1 = numDeque.pop();
            char op = opDeque.pop();
            int result = cal(num1,num2,op);
            numDeque.push(result);
        }
        if(!numDeque.empty())return numDeque.pop();
        return 0;
    }
    private boolean isNumber(char c){
        if(c>='0'&& c<= '9')return true;
        else return false;
    }
    private int cal(int num1, int num2, char op){
        if(op == '+') return num1+num2;
        if(op == '-') return num1-num2;
        return 0;
    }
}
