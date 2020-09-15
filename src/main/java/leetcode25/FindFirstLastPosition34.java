package leetcode25;

public class FindFirstLastPosition34 {
    public static void main(String[] args) {
        //int[]nums = {4,5,6,7,0,1,2};
        //int[]nums = {4,5,6,7,0,1,2};
        //int[]nums = {2,2,2,4,5,5,6,7,7};
        int target = 5;
        FindFirstLastPosition34 p = new FindFirstLastPosition34();
//        System.out.println(p.lowBound(nums,target));
//        System.out.println(p.upperBound(nums,target));
//        System.out.println(p.searchRange(nums,target)[0]);


        int[]nums = {1,3,5,6};
        System.out.println(p.searchInsert(nums,2));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
    * */
    public int searchInsert(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        if(nums[start]>target)return 0;
        if(nums[end]<target)return nums.length;
        int mid = 0;
        while(start<=end){
            mid =start+ (end-start)/2;
            if(nums[mid] == target){
                if(mid>0 &&nums[mid-1]==target){
                    end = mid-1;
                }else return mid;
            }
            else if(nums[mid]>target){
                if(mid>0){
                    if(nums[mid-1]<target)return mid;
                    if(nums[mid-1]==target)return mid-1;
                }
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return mid;
    }

    public int[] searchRange(int[] nums, int target) {
        int[]indexs = new int[2];
        indexs[0] = lowBound(nums,target);
        indexs[1] = upperBound(nums,target);
        return indexs;
    }
    //大于等于target的边界
    public int lowBound(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid =start+ (end-start)/2;
            if(nums[mid] == target){
                if(mid>0 &&nums[mid-1]==target){
                    end = mid-1;
                }else return mid;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    //小于等于target的边界
    public int upperBound(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid] == target){
                if(mid<nums.length-1 &&nums[mid+1]==target){
                    start = mid+1;
                }else return mid;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }
        return -1;
    }
}
