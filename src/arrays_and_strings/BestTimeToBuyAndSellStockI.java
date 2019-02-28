package arrays_and_strings;

public class BestTimeToBuyAndSellStockI {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        /*
        // Brute Force
        int maxDiff = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int diff = prices[j] - prices[i];
                 maxDiff = Math.max(maxDiff,diff);
            }
        }
       return maxDiff;
       */
        
        //Efficient Approach : O(n) single pass
        int minimumBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= minimumBuyPrice) {
                minimumBuyPrice = prices[i];
            } else {
                if (prices[i] - minimumBuyPrice >= maxProfit) {
                    maxProfit = prices[i] - minimumBuyPrice;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
