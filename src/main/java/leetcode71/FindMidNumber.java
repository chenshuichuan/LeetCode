package leetcode71;

public class FindMidNumber
{
    static int[] nums = new int[2];
    static int size = 0;
    //只存储两个数
    public static void storeNum(int i){
        if (size < 2)nums[size++] = i;
        else {
            nums[0] = nums[1];
            nums[1] = i;
        }
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m+n)/2;
        int index1 = 0;
        int index2 = 0;

        while(true){
            if(index1 < m && index2 < n){
                if(nums1[index1]<nums2[index2]){
                    storeNum(nums1[index1]);
                    index1++;
                }
                else{
                    storeNum(nums2[index2]);
                    index2++;
                }
            }
            else if(index1 < m){
                storeNum(nums1[index1]);
                index1++;
            }
            else if(index2 < n){
                storeNum(nums2[index2]);
                index2++;
            }
            if((index1+index2) > mid)break;

        }
        if ((m+n)%2 == 1)return nums[1];
        return (nums[0]+nums[1])/2.0;

    }
    public static void main(String[] args)
    {
        double mid = findMedianSortedArrays(new int[]{1,3},new int[]{2});
        System.out.println(mid);
    }
}
