package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring3 {
    public static void main(String[] args){
        System.out.println(new LengthOfLongestSubstring3().lengthOfLongestSubstring("abcabcbb"));

    }
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int max =0;
        Set<Character> charSet = new HashSet<Character>();

        while(j<s.length()){
            if (charSet.contains(s.charAt(j))){
                max = j-i>max?j-i:max;
                charSet.remove(s.charAt(i));
                i++;
            }
            else{
                charSet.add(s.charAt(j));
                j++;
            }
        }
        return j-i>max?j-i:max;
    }
}
