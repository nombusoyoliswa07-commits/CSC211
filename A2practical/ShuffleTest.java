import java.util.HashMap;
import java.util.Map;

public class ShuffleTest {

    public static void testShuffle(int N, boolean unbiased) {
        Map<String, Integer> D = new HashMap<>();

        for (int i = 0; i < 60000; i++) {
            int[] B;

            if (unbiased) {
                B = UnbiasedShuffle.shuffle(N);
            } else {
                B = BiasedShuffle.biasedshuffle(N);
            }

            String key = "" + B[0] + B[1] + B[2];

            if (!D.containsKey(key)) {
                D.put(key, 1);
            } else {
                D.put(key, D.get(key) + 1);
            }
        }

        for (String key : D.keySet()) {
            System.out.println(key + " " + D.get(key));
        }
    }

    public static void main(String[] args) {
        System.out.println("Biased shuffle:");
        testShuffle(3, false);

        System.out.println("\nUnbiased shuffle:");
        testShuffle(3, true);
    }
}

