package leetcode41;

public class TrappingRainWater42 {
//定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
//
//定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，但right_max对它而言是不可信的。（
// 见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
//
//定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
    public static void main(String[] args)  {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater42 p = new TrappingRainWater42();

        System.out.println(p.trap(height));
    }
    //双指针
    //对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
    // 这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
    // 无论右边将来会不会出现更大的right_max，都不影响这个结果。
    // 所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
    public int trap(int[] height) {
        if(height==null ||height.length==0)return 0;

        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
    //优化为两次循环和一个存储right_max的空间
    public int trap2(int[] height) {
        if(height==null ||height.length==0)return 0;

        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        int left = height[0];
        int sum = 0;
        //遍历i,根据左右最高height计算该i列的雨水
        for (int i = 1; i < height.length; i++) {
            left = Math.max(left,height[i]);
            sum+= Math.min(left,right[i])-height[i];
        }
        return sum;
    }
    //三次循环，left_max和right_max的存储空间
    public int trap3(int[] height) {
        if(height==null ||height.length==0)return 0;
        //计算左右第i位置的左右最高height
        int[] left = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }

        int sum = 0;
        //遍历i,根据左右最高height计算该i列的雨水
        for (int i = 0; i < height.length; i++) {
            sum+= Math.min(left[i],right[i])-height[i];
        }

        return sum;
    }
}
