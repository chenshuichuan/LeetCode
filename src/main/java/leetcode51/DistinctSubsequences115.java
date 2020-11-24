package leetcode51;

public class DistinctSubsequences115 {
    public static void main(String[] args){
        DistinctSubsequences115 p = new DistinctSubsequences115();
        String[] s = {"rabbbit","rabbit"};
        System.out.println(p.numDistinct(s[0],s[1]));

    }
    //dp[i][j] s的i位置，t的第j个字符出现的次数
    public int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if(ls==0||lt==0)return 0;
        int[][] dp= new int[ls][lt];
        if(s.charAt(0)==t.charAt(0))dp[0][0]=1;
        else dp[0][0]=0;
        for (int i = 1; i < ls; i++) {
            if(s.charAt(i)==t.charAt(0))dp[i][0]=dp[i-1][0]+1;
            else dp[i][0]=dp[i-1][0];
        }
        for (int j = 1; j < lt; j++) {
           if(s.charAt(0)==t.charAt(j))dp[0][j]=1;
           else dp[0][j] = 0;
        }
        for (int j = 1; j < lt; j++) {
            for (int i = 1; i < ls; i++) {
                if(s.charAt(i)==t.charAt(j))dp[i-1][j]=dp[i-1][j]+1;
                else dp[i][j]=dp[i-1][j];
            }
        }

        for (int i = 0; i < ls; i++) {
            for (int j = 1; j < lt; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }

        return 0;
    }

}
