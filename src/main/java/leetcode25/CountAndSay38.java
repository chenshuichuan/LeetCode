package leetcode25;

import java.util.Arrays;

public class CountAndSay38 {
    public static void main(String[] args){
        CountAndSay38 p = new CountAndSay38();
        //System.out.println(p.countAndSay2(30));
        System.out.println(p.countAndSay(30));
    }
    public String countAndSay(int n) {
        String nums = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder str = new StringBuilder();
            int j = 0;
            int count = 0;
            while (j<=nums.length()){
                if(j>0){
                    if(j==nums.length() || nums.charAt(j)!=nums.charAt(j-1)){
                        str.append(count);
                        str.append(nums.charAt(j-1));
                        count=0;
                    }
                }
                count++;
                j++;
            }
            nums = str.toString();
        }
        return nums;
    }
    private char[] nums = new char[6000];
    public String countAndSay2(int n) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = '0';
        }
        nums[0] = '1';
        for (int i = 1; i <= n; i++) {
            char[] temp = Arrays.copyOf(nums,nums.length);
            System.out.println("现在是："+i);
            System.out.println(Arrays.toString(temp));
            int j = 0;
            int count = 0;
            int lastI =0;
            while (true){
                if(j>0){
                     if(temp[j]!=temp[j-1] || temp[j]=='0'){
                         nums[lastI++] = (char)('0'+count);
                         nums[lastI++] = temp[j-1];
                         count=0;
                         if(temp[j]=='0')break;
                     }
                }
                count++;
                j++;
            }
        }
        return Arrays.toString(nums);
    }
}
