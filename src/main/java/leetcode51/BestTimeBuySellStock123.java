package leetcode51;

public class BestTimeBuySellStock123 {
    public static void main(String[] args){
//        int[]arr = {3,3,5,0,0,3,1,4};
        int[]arr = {3,1,3,6,2,8,1,4};
        BestTimeBuySellStock123 p = new BestTimeBuySellStock123();
        System.out.println(p.maxProfit(arr));
    }
    public int maxProfit(int[] prices) {
        if(prices.length<=0)return 0;
        //profit[i] i位置卖出得到的最大利润
        int[] profit = new int[prices.length];
        profit[0]=0;
        int min = prices[0];//最小price
        for(int i = 1;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            profit[i] = prices[i]-min;
        }
        //还是要求两段交易的最大值 profit可以看做从前往后的第一段
        //然后从后往前找第二段交易
        int max=0;//从后往前最大price
        int maxValue = 0;
        int result = profit[prices.length-1];
        for(int i = prices.length-1;i>0;i--){
            max = Math.max(max,prices[i]);
            maxValue = Math.max(maxValue,max-prices[i]);
            result = Math.max(result,profit[i-1]+maxValue);
        }
        return result;
    }
    //O(n)/O(1) 的解法
    public int maxProfit3(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
    public int maxProfit2(int[] prices) {
        if(prices.length<=0)return 0;
        //profit[i] i位置卖出得到的最大利润
        int[] profit = new int[prices.length];
        profit[0]=0;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(prices[i]<min) min = prices[i];
            profit[i] = prices[i]-min;
        }
        // max为最大卖出价
        int max = 0;
        int ans = profit[prices.length - 1];
        // value存储i~n-1之间的最大利润
        int value = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            }
            // i出买入，卖出为max
            value = Math.max(value, max - prices[i]);
            ans = Math.max(ans, profit[i - 1] + value);
        }
        return ans;
    }
}
