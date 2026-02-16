import java.util.Random;
import java.util.Arrays;


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



}
