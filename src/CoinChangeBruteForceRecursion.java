import java.util.Arrays;

public class CoinChangeBruteForceRecursion {
    public static void main(String[] args) {
        System.out.println(coins(41));
    }

    private static int coins(int money) {
        if (money <= 0) {
            return Integer.MAX_VALUE;
        }

        if (money == 1 || money == 5 || money == 20 || money == 25) {
            return 1;
        }

        final int min = Arrays.stream(new int[]{
                coins(money - 25),
                coins(money - 20),
                coins(money - 5),
                coins(money - 1)}).min().getAsInt();
        return min + 1;
    }
}
