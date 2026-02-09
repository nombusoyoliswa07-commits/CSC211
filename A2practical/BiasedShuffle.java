import java.util.Random;

public class BiasedShuffle {

    public static int[] biasedshuffle(int N) {
        Random rand = new Random();

        int[] shuffled = new int[N];


        for (int i = 0; i < N; i++) {
            shuffled[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            int r = rand.nextInt(N);
            int temp = shuffled[i];
            shuffled[i] = shuffled[r];
            shuffled[r] = temp;
        }

        return shuffled;
    }
}

