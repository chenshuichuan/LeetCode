package leetcode61;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryPrefixDivisibleByFive1018 {
    public static void main(String[] args) {
        //[false,false,false,false,false,false,false,false,false]
        int[] arr = {1,1,0,0,0,1,0,0,1};

        BinaryPrefixDivisibleByFive1018 p = new BinaryPrefixDivisibleByFive1018();
        List<Boolean> list = p.prefixesDivBy5(arr);
        System.out.println(list);

        Integer[] arr1 = {1,1,0,0,0,1,0,0,1};
        List<Integer> list1 = Arrays.asList(arr1);
        Integer[] arr2 = {1,1,0,0,0,1,0,0,1};
        List<Integer> list2 = Arrays.asList(arr2);
        list1.addAll(list2);
    }
    //被五整除的二进制序列
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new LinkedList<>();
        int sum =0;
        for(int i=0;i<A.length;i++){
            sum=sum%10+A[i];
            if(sum%5 ==0)ans.add(new Boolean(true));
            else ans.add(new Boolean(false));
            sum = sum<<1;
            System.out.println(sum);
        }
        return ans;
    }
}
