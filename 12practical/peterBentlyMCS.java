import java.util.Random;
import java.util.Arrays;
// 4535033
// Nombuso Mkhatshwa
// CSC211 Practical 2


public class peterBentlyMCS {

    public static void main(String[] args){

        int n = 20;

        Random rand = new Random();

        int[] X = new int[n];
        int countP = 0, countM = 0;

        for(int i=0; i<n;i++ ){

            int value = rand.nextInt(n) + 1;
            if (rand.nextInt(3) == 0) value *= -1;
            X[i] = value;

            if (value < 0) countM++;
            else countP++;
        }




    }
    // O(n^3)
    public static int mcsOn3(int[] X) {
        int n = X.length;
        int maxSoFar = 0;

        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = 0;
                for (int r = low; r <= high; r++) {
                    sum += X[r];
                    if (sum > maxSoFar) {
                        maxSoFar = sum;
                    }
                }
            }
        }
        return maxSoFar;
    }

    // O(n^2) – version A
    public static int mcsOn2A(int[] X) {
        int n = X.length;
        int maxSoFar = 0;

        for (int low = 0; low < n; low++) {
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += X[r];
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }
    // O(n^2) – version B (prefix sums)
    public static int mcsOn2B(int[] X) {
        int n = X.length;
        int[] sumTo = new int[n + 1];

        sumTo[0] = 0;
        for (int i = 1; i <= n; i++) {
            sumTo[i] = sumTo[i - 1] + X[i - 1];
        }

        int maxSoFar = 0;
        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = sumTo[high + 1] - sumTo[low];
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }



}
