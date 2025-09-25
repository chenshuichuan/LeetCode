package wei.ab200;

import java.util.Arrays;
import java.util.Scanner;

public class AB1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //
        int num = scanner.nextInt();
        scanner.nextLine();
        int outTime = scanner.nextInt();
        scanner.nextLine();
        String[] pTimes = scanner.nextLine().split(" ");
        int[] times = new int[num];
        for (int i = 0; i < num; i++) {
            times[i] = Integer.parseInt(pTimes[i]);
        }
        if(outTime<=0){
            System.out.println(0);
            System.out.println(0);
        }
        Arrays.sort(times);
        int totalTime = 0;
        int count = 0;
        for (int i = 1; i < num; i++) {
            if(totalTime<outTime){
                totalTime += times[i];
                count++;
                if((totalTime+times[0]) >= outTime){
                    break;
                }
                else totalTime += times[0];
            }
        }
        count++;


        System.out.println( count);
        System.out.println(totalTime);
    }
}
