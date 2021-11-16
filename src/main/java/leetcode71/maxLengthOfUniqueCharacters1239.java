package leetcode71;

import java.util.Arrays;
import java.util.List;

public class maxLengthOfUniqueCharacters1239 {
    public int maxLength(List<String> arr) {
        int[] lastLeft = new int[26];
        Arrays.fill(lastLeft,-1);
        int maxLength = 0;//

        for (int i = 0; i < arr.size(); i++) {
            //找出当前字符串左边能结合多少个
            char[] str = arr.get(i).toCharArray();
            int maxLeft= -1;
            for (int j = 0; j < str.length; j++) {
                int index = str[j] - 'a';
                if(lastLeft[index]>maxLeft){
                    maxLeft = lastLeft[index];
                }
                lastLeft[index] = i;
            }
            int maxL = 0;
            if(maxLeft == (i-1) ){
                maxL = str.length;
            }
            else{
                for (int j = maxLeft+1; j <=i; j++) {
                    maxL += arr.get(j).length();
                }
            }
            maxLength = maxLength>maxL?maxLength : maxL;

        }

        return maxLength;
    }
}