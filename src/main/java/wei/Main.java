package wei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        long startTime=System.currentTimeMillis();
        System.out.println("执行代码块/方法");

        int x=2;
        int y=3;
        Scanner in  = new Scanner(System.in);
        for (int i = 0; i < 1000000000; i++) {
            int z = x+y;
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");


        System.out.println(getWeekHours("讲课(2.0)"));
    }
    public static float getWeekHours(String stringHours){
        int startIndex = stringHours.indexOf("(");
        int endIndex = stringHours.indexOf(")");
        return Float.valueOf(stringHours.substring(startIndex+1,endIndex));
    }
}
