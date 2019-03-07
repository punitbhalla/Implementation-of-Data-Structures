package arrays_and_strings;

public class WaterAndJugProblem {
    public static boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }

        if (x == z || y == z || ((x + y) == z)) {
            return true;
        }

        return (z % gcd(x, y) == 0);

    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        int x = 3, y = 5, z = 4;
        System.out.println(canMeasureWater(x, y, z));
    }
}
