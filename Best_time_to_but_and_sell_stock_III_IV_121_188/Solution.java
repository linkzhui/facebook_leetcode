package Facebook.Best_time_to_but_and_sell_stock_III_IV_121_188;


//我们需要维护两个变量，global【i】【j】 and local【i】【j】，
//i means the date, j means how many transaction we have made
//the global means, we have make k transaction, from 0 to ith day.
//the local means, end of today, we have make k time transaction,
//the local[i][j] means we have make j transaction from 0 to i,
//the difference between local and global is, local means if I must sell stock today
//global[i][j]=max(local[i][j],global[i-1][j]), 情况1： 比较我i-1 天前，make k time transcation, the global value 情况2：end of day, we make k transcation


//local[i][j] = max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff);
//情况1：the first global means, from day 0 to day i-1, we have make j - 1 transaction,then plus today's transaction
//情况2： the local means, from day o to day i-1, we have already make j transaction, plus today's transaction (why we already make k transaction, we
// still make make one more transaction, that is because the continues transaction will consider as one transaction,
// such as I buy stock at day 1, sell stock at day 2, then i buy stock at day 2 and sell stock at day 3 = I buy stock at day 1 and sell stock at day 3)

//the time complexity is O(n*k) -> the k means k times transaction, the n means how many days
//for the space complexity, we only care about the precious day, therefore it is O(1)

//corner case: if transaction time is larger than days, then we can implement greedy algorithm to get the result
public class Solution {
    public int maxProfits(int k, int[] prices)
    {
        if(prices == null || prices.length == 0 || k <0)
        {
            return 0;
        }

        int[] global = new int[k+1];
        int[] local = new int[k+1];

        for(int i = 1;i<prices.length;i++)
        {
            int diff = prices[i] - prices[i-1];
            //because local[i][j] = max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff);
            //therefore local[j] depend on global[j-1] and local[j],
            for(int j = k; j>0;j--)
            {
                //becase global depend on the today's local, therefore we update the local first
                local[j] = Math.max(global[j-1],local[j]+diff);
                global[j] = Math.max(global[j],local[j]);
            }
        }
        return global[k];
    }

    private int greedy(int[] prices)
    {
        int profix = 0;
        for(int i = 1;i<prices.length;i++)
        {
            profix+=Math.max(0,prices[i]-prices[i-1]);
        }
        return profix;
    }
}
