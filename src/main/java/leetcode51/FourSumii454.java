package leetcode51;

import java.util.HashMap;

public class FourSumii454 {
    public static void main(String[] args){
        FourSumii454 p = new FourSumii454();
        int[]A = { -1, -1};
        int[]B = {-1,1};
        int[]C = {-1, 1};
        int[]D = { -1, 1};
//        int[]A = { 1, 2};
//        int[]B = {-2,-1};
//        int[]C = {-1, 2};
//        int[]D = { 0, 2};
        //2
        System.out.println(p.fourSumCount(A,B,C,D));

    }
    //计算四个数相加为0的组合数
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //先用hash表存两个数的和
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i]+B[j];
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                }
                else map.put(sum,1);
            }
        }

        //再和另外两个数的和比较
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = C[i]+D[j];
                if(map.containsKey(-sum)){
                    int value = map.get(-sum);
                    //这是乘积关系2*2
                    count+=value;
                }
            }
        }
        return count;
    }
}
