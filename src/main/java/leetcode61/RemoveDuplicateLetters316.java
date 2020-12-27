package leetcode61;

import java.util.Stack;

public class RemoveDuplicateLetters316 {
    public static void main(String[] args) {
        RemoveDuplicateLetters316  p = new RemoveDuplicateLetters316();
        System.out.println(p.removeDuplicateLetters("bbcaac"));
    }
    /**
     * 从左往右遍历入栈，遇到左边字符比右边字符大，且左边字符计数仍大于1时，删除左边字符
     * */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!visited[c-'a']){
                while (!stack.empty()){
                    char top = stack.pop();
                    if(top>c && count[top-'a']>1){
                        count[top-'a']--;
                        visited[top-'a'] = false;
                    }else{
                        stack.push(top);
                        break;
                    }
                }
                stack.push(c);
                visited[c-'a'] = true;
            }
            else{
                count[c-'a']--;
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.empty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
    //1081 :返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。

    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!visited[c-'a']){
                while (!stack.empty()){
                    char top = stack.pop();
                    if(top>c && count[top-'a']>1){
                        count[top-'a']--;
                        visited[top-'a'] = false;
                    }else{
                        stack.push(top);
                        break;
                    }
                }
                stack.push(c);
                visited[c-'a'] = true;
            }
            else{
                count[c-'a']--;
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.empty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
