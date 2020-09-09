package leetcode25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationWords30 {
    public static void main(String[] args){
        System.out.println("123456".substring(0,3));
        SubstringWithConcatenationWords30 p  = new SubstringWithConcatenationWords30();
        String  s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(p.findSubstring(s,words).size());
        String[]words2 = {"bar","foo","the"};
        System.out.println(p.findSubstring("barfoofoobarthefoobarman",words2).size());
        String s3= "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words3 =      {"fooo","barr","wing","ding","wing"};
        System.out.println(p.findSubstring(s3,words3).size());
        String []words4= {"a"};
        System.out.println(p.findSubstring("a",words4).size());
        String s5 = "abababab";
         String[]words5 =        {"ab","ba"};
        System.out.println(p.findSubstring(s5,words5).size());
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> wMap = new HashMap<>();
        for (String str: words) {
            wMap.put(str,wMap.getOrDefault(str,0)+1);
        }
        int len = words[0].length();
        int wlen = len*words.length;

        for (int i = 0; i <= s.length()-wlen; i++) {
            String str = s.substring(i,i+len);
            if(wMap.containsKey(str)){
                Map<String, Integer> temp = new HashMap<>(wMap);
                int j = i;
                int count = 0;//通过count去计算是否都刚好用完所有的word。而不需另外遍历map查找
                while (j<s.length()){
                    str = s.substring(j,j+len);
                    if(!wMap.containsKey(str))break;
                    int times = temp.get(str)-1;
                    temp.put(str,times);
                    j+=len;
                    if(j-i>wlen ||times<0)break;
                    if(times==0)count++;
                    if(times == 0 && j-i==wlen){
                        break;
                    }
                }
                if(count == wMap.size())
                    list.add(i);
            }
        }
        return list;
    }
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> wMap = new HashMap<>();
        for (String str: words) {
            wMap.put(str,wMap.getOrDefault(str,0)+1);
        }
        int len = words[0].length();
        int wlen = len*words.length;

        for (int i = 0; i <= s.length()-wlen; i++) {
            String str = s.substring(i,i+len);
            if(wMap.containsKey(str)){
                Map<String, Integer> temp = new HashMap<>(wMap);
                int j = i;
                while (j<s.length()){
                    str = s.substring(j,j+len);
                    if(!wMap.containsKey(str))break;
                    int times = temp.get(str)-1;
                    temp.put(str,times);
                    j+=len;
                    if(j-i>wlen ||times<0)break;
                    if(times == 0 && j-i==wlen){
                        boolean get = true;
                        for (String key :
                                temp.keySet()) {
                            if (temp.get(key) !=0){
                                get = false;break;
                            }
                        }
                        //有效的查找
                        if(get) list.add(i);
                        break;
                    }
                }
            }
        }
        return list;
    }
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> wMap = new HashMap<>();
        for (String str: words) {
            wMap.put(str,wMap.getOrDefault(str,0)+1);
        }
        int len = words[0].length();
        int wlen = len*words.length;
        for (int i = 0; i <= s.length()-wlen; i++) {
            String str = s.substring(i,i+len);
            if(wMap.containsKey(str)){
                Map<String, Integer> temp = new HashMap<>(wMap);
                temp.put(str,temp.get(str)-1);
                int j = i+len;
                while (j<s.length()){
                    str = s.substring(j,j+len);
                    if(!wMap.containsKey(str))break;
                    int times = temp.get(str)-1;
                    temp.put(str,times);
                    j+=len;
                    if(times == 0 && j-i==wlen){
                        boolean get = true;
                        for (String key :
                                temp.keySet()) {
                            if (temp.get(key) !=0){
                                get = false;break;
                            }
                        }
                        //有效的查找
                        if(get) list.add(i);
                    }
                }
            }
        }
        return list;
    }
}
