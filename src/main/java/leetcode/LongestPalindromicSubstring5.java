package leetcode;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args){
        LongestPalindromicSubstring5 p = new LongestPalindromicSubstring5();
        System.out.println(p.longestPalindrome("abc"));
        System.out.println(p.longestPalindrome("aaa"));
    }
    public String longestPalindrome(String s) {
        int maxi = 0;
        int maxj = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); ) {
            int j = i;
            int k = i+flag;
            i = i+flag;
            flag=flag==0?1:0;

            while (j>=0&&k<s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    j--;
                    k++;
                }
                else break;
            }
            //找到更大的子串
            if(k-j-2>maxj-maxi && j+1<k-1){
                maxi = j+1;
                maxj = k-1;
            }
        }
        if(maxi>=0 && maxj<s.length() && maxj>= maxi)return s.substring(maxi,maxj+1);
        else return "";
    }

}
