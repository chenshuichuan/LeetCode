package leetcode71;

import java.util.ArrayList;
import java.util.List;

public class NStringBuilder {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i=0; i< numRows; i++){
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            list.get(row).append(s.charAt(i));
            if(row==0){
               flag =true;
            }
            if(row==numRows-1){
                flag = false;
            }
            if( flag) row++;
            else row--;
        }
        StringBuilder str = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            str.append(stringBuilder);
        }
        return str.toString();
    }
    public static void main(String[] args) {
        System.out.println(new NStringBuilder().convert("PAYPALISHIRING", 1));
    }
}
