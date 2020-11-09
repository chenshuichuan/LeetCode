package leetcode41;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters1002 {

    public static void main(String[] args)  {
        String[] str = {"cool","lock","cook"};
        FindCommonCharacters1002 p = new FindCommonCharacters1002();

        System.out.println(p.commonChars(str));
    }

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if(A==null||A.length==0)return result;

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < A[0].length(); i++) {
            String key = A[0].substring(i,i+1);
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }
        Map<String,Integer> pre = new HashMap<>(map);
        for (int i = 1; i < A.length; i++) {
            Map<String,Integer> tMap = new HashMap<>(pre);
            for (int j = 0; j < A[i].length(); j++) {
                String key = A[i].substring(j,j+1);
                if(tMap.containsKey(key)){
                    tMap.put(key,tMap.get(key)-1);
                }
            }
            pre.clear();
            for (String key :
                    tMap.keySet()) {
                int num = tMap.get(key);
                int num2 = map.get(key);
                if(num<num2){
                    if(num>=0){
                        pre.put(key,num2-num);
                        map.put(key,num2-num);
                    }
                    else pre.put(key,num2);
                }
            }
        }
        for (String key :
                pre.keySet()) {
            int num = pre.get(key);
            for (int i = 0; i < num; i++) {
                result.add(key);
            }
        }
        return result;
    }
}
