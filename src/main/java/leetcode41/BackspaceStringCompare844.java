package leetcode41;

import java.util.Stack;

public class BackspaceStringCompare844 {

    public static void main(String[] args)  {
        BackspaceStringCompare844 p = new BackspaceStringCompare844();
        String S = "ab#c", T = "ad#c";
        System.out.println(p.backspaceCompare(S,T));

    }
    public boolean backspaceCompare(String S, String T) {
        int s = 0;
        StringBuilder sBuilder = new StringBuilder();
        for (int i = S.length()-1; i >=0; i--) {
            char c= S.charAt(i);
            if(c=='#')s++;
            else{
                if(s==0)sBuilder.insert(0,c);
                else s--;
            }

        }
        int t = 0;
        StringBuilder tBuilder = new StringBuilder();
        for (int i = T.length()-1; i >=0; i--) {
            char c= S.charAt(i);
            if(c=='#')t++;
            else{
                if(t==0)tBuilder.insert(0,c);
                else t--;
            }

        }
        return sBuilder.toString().equals(tBuilder.toString());
    }
    public boolean backspaceCompare2(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c=='#'){
                if(!sStack.empty()){
                    sStack.pop();
                }
            }else{
                sStack.push(c);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if(c=='#'){
                if(!tStack.empty()){
                    tStack.pop();
                }
            }else{
                tStack.push(c);
            }
        }

        while(!sStack.empty()&&!tStack.isEmpty()){
            char s = sStack.pop();
            char t = tStack.pop();
            if(s!=t) return false;
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }
}
