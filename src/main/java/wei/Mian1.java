package wei;


import java.util.Arrays;
import java.util.Scanner;
public class Mian1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] array = new int[num];
        for(int i=0;i<num;i++){
            int temp = in.nextInt();
            if(i==0)array[i] = temp;
            for(int j =i;j>0;j--){
                if(temp<array[j-1]){
                    array[j]=array[j-1];
                }
                else{array[j]=temp;break;}
            }
        }
        System.out.println(Arrays.toString(array));

    }
    public void print(int[]array){
        //for(int i=0;i<array.length)
    }
}