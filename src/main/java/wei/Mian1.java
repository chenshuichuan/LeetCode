package wei;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Mian1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println();
    }
    public void print(int n){
        List<String> list = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            String str=String.valueOf(i);
            if(i%3==0 && i%5==0)str = "FizzBuzz";
            else if(i%3==0) str = "Fizz";
            else if(i%5==0) str = "Buzz";
            list.add(str);
        }
    }
}