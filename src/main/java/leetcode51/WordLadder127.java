package leetcode51;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args)  {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(strings);
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
}
