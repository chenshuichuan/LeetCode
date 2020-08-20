package leetcode;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class StringAdd {
    public static void main(String[] args){
        System.out.println(new StringAdd().addStrings("123456789","987654321"));
        String str = "123";
        System.out.println(str);
        Field field = null;
        try {
            field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[]) field.get(str);
            value[1] = '3';
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(str);

    }
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int add = 0;
        StringBuilder str =new StringBuilder();
        while(i>=0 || j>=0|| add >0){
            int a = i>=0?num1.charAt(i)-'0':0;
            int b = j>=0?num2.charAt(j)-'0':0;
            int result = a+b+add;
            str.append(result<10?result:result%10);
            add = result/10;
            i=i-1;
            j=j-1;
        }
        str.reverse();
       return str.toString();
    }
}
