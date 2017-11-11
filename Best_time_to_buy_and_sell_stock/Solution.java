package Facebook.Best_time_to_buy_and_sell_stock;


//solution 1: 求出只做一次交易，能获得的最大利益数
//只需要找出最大的差值即可，即 max(prices[j] – prices[i]) ，i < j。
// 一次遍历即可，在遍历的时间用遍历low记录 prices[o….i] 中的最小值，
// 就是当前为止的最低售价，时间复杂度为 O(n)。


//solution 2: 可以做无限次的交易，
//gready, if prices[i-1]<prices[i], we will do transaction, if prices[i+1]>prices[i], we still can profit from next one,
// if prices[i]>prices[i+1],then we sell prices[i-1] at prices[i] will be more profit.

public class Solution {
    public static void main(String[] args)
    {
        Solution sol = new Solution();
        int[] prices = {0,6,-3,7};
        System.out.println(sol.solution_1(prices));
    }
    public int solution_1(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;

        // 第i天的价格可以看作是买入价也可以看作是卖出价
        for (int i = 1; i < prices.length; i++) {
            // 找到更低的买入价
            if (min > prices[i]) {
                // 更新买入价
                min = prices[i];
            }
            // 当天的价格不低于买入价
            else {
                // 如果当天买出的价格比之前卖出的价格高
                if (profit < prices[i] - min) {
                    // 更新卖出价
                    profit = prices[i] - min;
                }
            }
        }

        return profit;
    }


    public int solution_2(int[] prices) {
        if(prices == null || prices.length == 0)
        {
            return 0;
        }
        int profit = 0;
        for(int i = 1;i<prices.length;i++)
        {
            if(prices[i-1]<prices[i])
            {
                profit += prices[i] - prices[i-1];
            }

        }
        return profit;
    }
}
