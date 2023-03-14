package utils;

import java.util.Arrays;

public class Probability {

    public static Float[] analyze(Counter counter) {
        int uniqueCharCount[] = counter.getUniqueCharCount();
        int sum = 0;
        Float[] probabilities = new Float[0];

        for(int i = 0; i<uniqueCharCount.length; i++){
            sum = sum + uniqueCharCount[i];
        }

        for(int i = 0; i<uniqueCharCount.length; i++){
            probabilities = Arrays.copyOf(probabilities, probabilities.length+1);
            probabilities[probabilities.length-1] = (float) uniqueCharCount[i]/sum;
        }
//
//        System.out.println(sum);
//        System.out.println(Arrays.toString(probabilities));
//
        return probabilities;
    }
}
