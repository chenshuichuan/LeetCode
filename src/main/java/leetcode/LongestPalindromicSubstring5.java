package leetcode;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args){
        LongestPalindromicSubstring5 p = new LongestPalindromicSubstring5();
        //System.out.println(p.longestPalindrome("abc"));
        //System.out.println(p.longestPalindrome("aaa"));
        System.out.println(p.longestPalindrome2("cbbbbbaaaaaaaaaaad"));
    }
    //双中心检测法
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
    public String longestPalindrome2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = 1;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j)?1:0;
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]==1)?1:0;
                }
                if (dp[i][j]==1 && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return ans;
    }
}
