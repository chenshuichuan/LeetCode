package leetcode11;

public class PredictTheWinner486 {
    public static void main(String[] args){
        PredictTheWinner486 p = new PredictTheWinner486();

        //int[]nums = {1,5,233,7};
        int[]nums = {1,5,2};
        System.out.println(p.PredictTheWinner(nums));

    }
    public boolean PredictTheWinner(int[] nums) {
        return treeTotal(nums, 0, nums.length - 1, 1) >= 0;
    }
    /**
     *
     * */
    private int treeTotal(int[]nums,int start, int end, int turn){
        if(start>=end){
            return nums[start]*turn;
        }
        int left = nums[start]*turn+treeTotal(nums,start+1,end,-turn);
        int right = nums[end]*turn+treeTotal(nums,start,end-1,-turn);
        return left*turn>right*turn?left:right;
    }
}
