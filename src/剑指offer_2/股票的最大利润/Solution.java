package 剑指offer_2.股票的最大利润;

public class Solution {

    public int maxProfit(int[] prices) {
        //记录最低价格
        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {
            cost = Math.min(cost, price);

            profit = Math.max(profit, price - cost);
        }

        return profit;
    }
}
