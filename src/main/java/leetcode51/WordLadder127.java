package leetcode51;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args)  {
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] strings = {"hot","dot","dog","lot","log","cog"};
//        List<String> wordList = Arrays.asList(strings);

        WordLadder127 p = new WordLadder127();
        //0,1,1,2,3,1,1,3,4,0,0,2;
        String[] s={"0","10","2","12","226","27","2101","1201234","2611055971756562","230","301","17"};
        for (String str:s) {
            System.out.println(p.numDecodings(str));
        }
    }
    private int minPath = Integer.MAX_VALUE;
    private Map<String,Integer> visited =new  HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            visited.put(wordList.get(i),0);
        }
        dfs(beginWord,endWord,wordList);
        return minPath;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList){
        if(beginWord.equals(endWord))return;
        //拿到可以转换的单词列表
        //遍历dfs

    }

    //91. 解码方法
    //dp[i] = dp[i-1]+dp[i-2];
    //dp[i]代表第i个字符处的解个数
    public int numDecodings2(String s) {
        int l = s.length();
        if(l<1 ||s.charAt(0)=='0')return 0;
        if(l==1)return 1;
        int[]dp = new int[l];
        dp[0]=1;
        if(s.charAt(0)=='1')
            dp[1]=2;
        else if(s.charAt(0)=='2') {
            if(s.charAt(1)>'6')dp[1] = 1;
            else dp[1] = 2;
        }else {
            if(s.charAt(1)=='0')return 0;
            dp[1]=1;
        }
        if(s.charAt(1)=='0') dp[1] = 1;

        for(int i=2;i<l;i++){
            if(s.charAt(i-1)=='0'){
                if(s.charAt(i)=='0')return 0;
                dp[i] = dp[i-1];
            }else if(s.charAt(i-1)>'2'){
                if(s.charAt(i)=='0')return 0;
                dp[i] = dp[i-1];
            }else if(s.charAt(i-1)=='2'){
                if(s.charAt(i)=='0')dp[i] = dp[i-2];
                else if(s.charAt(i)>'6')dp[i] = dp[i-1];
                else dp[i] = dp[i-1]+dp[i-2];
            }else{
                if(s.charAt(i)=='0')dp[i] = dp[i-2];
                else dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[l-1];
    }
    //优化空间
    public int numDecodings(String s) {
        int l = s.length();
        if(l<1 ||s.charAt(0)=='0')return 0;
        if(l==1)return 1;
        int p2=1;
        int p1 = 2;
        if(s.charAt(0)=='1')
            p1=2;
        else if(s.charAt(0)=='2') {
            if(s.charAt(1)>'6')p1 = 1;
            else p1 = 2;
        }else {
            if(s.charAt(1)=='0')return 0;
            p1=1;
        }
        if(s.charAt(1)=='0') p1 = 1;
        int p=p1;
        for(int i=2;i<l;i++){
            if(s.charAt(i-1)=='0'){
                if(s.charAt(i)=='0')return 0;
                p = p1;
            }else if(s.charAt(i-1)>'2'){
                if(s.charAt(i)=='0')return 0;
                p = p1;
            }else if(s.charAt(i-1)=='2'){
                if(s.charAt(i)=='0')p = p2;
                else if(s.charAt(i)>'6')p = p1;
                else p = p1+p2;
            }else{
                if(s.charAt(i)=='0')p = p2;
                else p = p1+p2;
            }
            p2=p1;
            p1=p;
        }
        return p;
    }
}
