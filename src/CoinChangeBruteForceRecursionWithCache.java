import java.util.Arrays;

public class CoinChangeBruteForceRecursionWithCache {
    public static void main(String[] args) {
        System.out.println(coins(41));
        System.out.println(coins(6));
    }

    private static int coins(int money) {
        int[] dp = new int[money + 1];
        if (money >= 1) dp[1] = 1;
        if (money >= 5) dp[5] = 1;
        if (money >= 20) dp[20] = 1;
        if (money >= 25) dp[25] = 1;

        return coins(money, dp);
    }

    private static int coins(int money, int[] dp) {
        if (money <= 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[money] == 0) {
            System.out.printf("money = %02d%n", money);
            final int min = Arrays.stream(new int[]{
                    coins(money - 25, dp),
                    coins(money - 20, dp),
                    coins(money - 5, dp),
                    coins(money - 1, dp)
            }).min().getAsInt();
            dp[money] = min + 1;
        }
        return dp[money];
    }
}
