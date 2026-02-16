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

        System.out.println("countM = " + countM + "  countP = " + countP);
        System.out.println(Arrays.toString(X));

        System.out.println(mcsOn3(X));
        System.out.println(mcsOn2A(X));
        System.out.println(mcsOn2B(X));
        System.out.println(mcsOn(X));
        // System.out.println(mcsOnlogn(X, 0, X.length - 1));




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
    // Helper for divide-and-conquer
    public static int maxStraddle(int[] X, int low, int high) {
        int mid = (low + high) / 2;

        int sum = 0, maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum += X[i];
            maxLeft = Math.max(maxLeft, sum);
        }

        sum = 0;
        int maxRight = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += X[i];
            maxRight = Math.max(maxRight, sum);
        }

        return maxLeft + maxRight;
    }
    // O(n log n)
    public static int mcsOnlogn(int[] X, int low, int high) {
        if (low > high) return 0;
        if (low == high) return Math.max(0, X[low]);

        int mid = (low + high) / 2;
        int left = mcsOnlogn(X, low, mid);
        int right = mcsOnlogn(X, mid + 1, high);
        int straddle = maxStraddle(X, low, high);

        return Math.max(Math.max(left, right), straddle);
    }
    // O(n) – Kadane’s Algorithm
    public static int mcsOn(int[] X) {
        int maxSoFar = 0;
        int maxToHere = 0;

        for (int x : X) {
            maxToHere = Math.max(maxToHere + x, 0);
            maxSoFar = Math.max(maxSoFar, maxToHere);
        }
        return maxSoFar;
    }





}
