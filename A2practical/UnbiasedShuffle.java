import java.util.Random;

public class UnbiasedShuffle {

    public static int[] shuffle(int N) {
        Random rand = new Random();

        int[] B = new int[N];


        for (int i = 0; i < N; i++) {
            B[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N - i);
            int temp = B[i];
            B[i] = B[r];
            B[r] = temp;
        }

        return B;
    }
}

