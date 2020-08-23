package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion6 {
    public static void main(String[] args){
        ZigzagConversion6 p = new ZigzagConversion6();

        System.out.println(p.convert("LEETCODEISHIRING",2));
        System.out.println(p.convert("ABC",2));
        System.out.println(p.convert("AB",1));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1)return s;
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            int i=0;
            StringBuilder temp = new StringBuilder();
            while (i<s.length()){
                int index = (numRows*2-2)*i+j;
                if (index>s.length()-1)break;
                temp.append(s.charAt(index));
                if(j==0 || j==numRows-1){//一个周期只有一个
                }else{//一个周期可能有两个
                    //第二个
                    index=index+(numRows-j-1)*2;
                    if (index>s.length()-1)break;
                    temp.append(s.charAt(index));
                }
                i++;
            }
            str.append(temp);
        }
        return str.toString();
    }
}
