package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class LetterPhoneNumber17 {
    public static void main(String[] args){
        LetterPhoneNumber17 p = new LetterPhoneNumber17();
        System.out.println(p.letterCombinations("2345").toString());
    }

    private List<String> stringList = new ArrayList<String>();
    private String[] strings = {"!@#","abc","def","ghi","jkl","nmo","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        StringBuilder stringBuilder = new StringBuilder();
        if(digits.length()>0)dfs(digits,0,stringBuilder);
        return stringList;
    }
    private void dfs(String digits,int index, StringBuilder stringBuilder){
        if(index == digits.length()){
            stringList.add(stringBuilder.toString());
            return;
        }
        String str = strings[digits.charAt(index)-'1'];
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            dfs(digits,index+1,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

}
