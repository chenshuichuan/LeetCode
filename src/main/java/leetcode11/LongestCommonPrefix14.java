package leetcode11;

import java.util.List;

public class LongestCommonPrefix14 {
    public static void main(String[] args){
        LongestCommonPrefix14 p = new LongestCommonPrefix14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(p.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1)return "";
        int index = shortestString(strs);
        int max = strs[index].length();
        if(max<1)return "";
        for (int j = 0; j <strs.length; j++) {
            if(j!=index){
                for (int i =0;i<strs[index].length();i++) {
                    if(i>max )break;
                    if(strs[j].charAt(i)!=strs[index].charAt(i)){
                        max = i;
                        break;
                    }
                }
            }
        }
        return strs[index].substring(0,max);
    }
    public int shortestString(String[]strs){
        int min = 0;
        for (int i = 1; i < strs.length; i++) {
            if(strs[min].length()>strs[i].length())min = i;
        }
        return min;
    }
}
