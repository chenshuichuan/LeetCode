package leetcode61;

public class PatchingArray330 {

    public static void main(String[] args) {

        PatchingArray330 p = new PatchingArray330();
        //1,2,0,3
        //2080374784
        //2147483647
        int[][]numsList = {{1,3},{1,5,10},{1,2,2},{},{1,2,31,33}};
        int[]ks = {6,20,5,5,2147483647};
        for (int i=0;i<numsList.length;i++) {
            System.out.println(p.minPatches(numsList[i],ks[i]));
        }

        int[]list = {1,2,4,8,16,31,32,62,124,248,496,992,1984,3968,7936,15872,31744,63488,126976,253952,507904,1015808,2031616,4063232,8126464,16252928,32505856,65011712,130023424,260046848,520093696,1040187392,2080374784};
        //System.out.println(p.validate(list,2147483647));
    }
    //按要求补齐数组nums,使得[1,k]范围内的任意数字可以用 nums 中某几个数字的和来表示
    //核心思想：[0,x] 范围+k k属于[0,x],则可以覆盖[0,x+k]范围
    public int minPatches(int[] nums, int n) {
        int res = 0;
        long i = 1;
        int index = 0;
        while(i<n){
           System.out.print(i+",");
            if(index<nums.length){
                if(nums[index]>i) {
                    res++;
                    if(i+i>nums[index])i=nums[index++];
                }
                else{
                    if(nums[index]==i) i+=i;
                    index++;
                    continue;
                }
            }
            else {
                res++;
            }
            i+=i;
        }
        return res;
    }


    public int minPatches2(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while (x <= n) {
            System.out.print(x+",");
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }

    //暴力验证：[1,n] 中任意一个数能由nums中的数字组合而成
    public boolean validate(int[] nums, int n){
        for(int i = 1;i<=n;i++){
            int j = i;
            int index = nums.length-1;
            if(i%100==0)System.out.println(i);
            while (j>0){
                if(j>=nums[index])j-=nums[index--];
                else index--;
                if(index<0 && j>0){
                    return false;
                }
            }
        }

        return true;
    }
}
