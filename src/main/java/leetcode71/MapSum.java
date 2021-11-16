package leetcode71;

import java.util.HashMap;

public class MapSum {

    private TrieNode root;
    private HashMap<String,Integer> map;
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {

        if(map.containsKey(key)){
            int cha = val - map.get(key) ;
            TrieNode temp = root;
            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i)-'a';
                if(temp.next[index]==null){
                    return;
                }
                temp.next[index].val += cha;
                temp = temp.next[index];
            }
            return;
        }
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i)-'a';
            if(temp.next[index]==null){
                temp.next[index]= new TrieNode();
                temp.next[index].val = val;
            }
            else temp.next[index].val += val;
            temp = temp.next[index];
        }
    }

    public int sum(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i)-'a';
            if(temp.next[index]==null){
                return 0;
            }
            temp = temp.next[index];
        }
        return temp.val;
    }
}
class TrieNode {
    public int val = 0;
    public TrieNode[] next = new TrieNode[26];
}
