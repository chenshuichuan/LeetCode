package leetcode61;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class BestTimeToBuyAndSellStockIV188 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV188 p = new BestTimeToBuyAndSellStockIV188();
        int k = 2;
        int[]prices = {3,2,6,5,0,3};
        System.out.println(p.maxProfit(k,prices));
    }
    //买卖股票的最大利润，最多k次
    public int maxProfit(int k, int[] prices) {

        int[] sell = new int[k+1];
        int[] buy = new int[k+1];
        for (int i = 0; i < buy.length;i++){
            buy[i] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int j = 1; j < k+1; j++) {
                buy[j] = Math.max(buy[j], sell[j-1]-price);
                sell[j] = Math.max(sell[j], buy[j]+price);
            }
        }
        return sell[k];
    }
}
