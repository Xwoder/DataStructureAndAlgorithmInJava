public class CoinChangeDynamicProgramming {
    public static void main(String[] args) {
        System.out.println(coins(41));
        System.out.println(coins(6));
    }

    private static int coins(int money) {
        final int[] dp = new int[money + 1];

        for (int i = 1; i < dp.length; i++) {
            int min = dp[i - 1];
            if (i >= 5) min = Math.min(min, dp[i - 5]);
            if (i >= 20) min = Math.min(min, dp[i - 20]);
            if (i >= 25) min = Math.min(min, dp[i - 25]);
            dp[i] = min + 1;
        }

        return dp[money];
    }
}
