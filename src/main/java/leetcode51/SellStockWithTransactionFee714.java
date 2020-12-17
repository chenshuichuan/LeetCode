package leetcode51;

public class SellStockWithTransactionFee714 {
    public static void main(String[] args) {

//        int[] prices={1, 3, 2, 8, 4, 9};
//        int fee = 2;
        int[] prices={1,3,7,5,10,3};
        int fee = 3;
        SellStockWithTransactionFee714 p = new SellStockWithTransactionFee714();
        System.out.println(p.maxProfit(prices,fee));
    }
    public int maxProfit(int[] prices, int fee) {

        //dp[0][i] 表示第i天手里没有股票的最大收益=前一天也没有或是前一天有i天卖掉 dp[0][i] = dp[0][i-1]>dp[1][i-1]+prices[i]-2
        //dp[1][i] 表第i天手里有股票的最大收益=前一天没有，i天买的，前一天有，i天=i-1
        int[]dp = new int[2];
        dp[0]= 0;
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sold = dp[1]+prices[i]-fee;
            int temp = dp[0];
            dp[0] = Math.max(dp[0],sold);

            dp[1]= Math.max(temp-prices[i],dp[1]);
        }
        return dp[0];
    }
}
