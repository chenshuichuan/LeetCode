package leetcode11;

public class ContainerWithMostWater11 {
    public static void main(String[] args){
        ContainerWithMostWater11 p = new ContainerWithMostWater11();
        int[]nums = { 1,8,6,2,5,4,8,3,7};
        System.out.println(p.maxArea(nums));
    }
    public int maxArea(int[] height) {

        int i=0;
        int j = height.length-1;
        int maxi =0;
        int temp = 0;
        while(i<j){
             if(height[i]>height[j]){
                 temp = height[j]*(j-i);
                 j--;
             }else{
                 temp = height[i]*(j-i);
                 i++;
             }
             maxi = temp>maxi?temp:maxi;
        }
        return maxi;
    }
}
