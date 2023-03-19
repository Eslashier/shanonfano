package utils;
import java.util.Arrays;
import java.util.Comparator;

public class Sorter {
    public static Counter analyze(int[] intArray, char[] charArray) {

        IntegerCharPair[] pairs = new IntegerCharPair[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            pairs[i] = new IntegerCharPair(intArray[i], charArray[i]);
        }

        Arrays.sort(pairs, new Comparator<IntegerCharPair>() {
            @Override
            public int compare(IntegerCharPair p1, IntegerCharPair p2) {
                return p2.getIntegerValue() - p1.getIntegerValue();
            }
        });

        for (int i = 0; i < pairs.length; i++) {
            intArray[i] = pairs[i].getIntegerValue();
            charArray[i] = pairs[i].getCharValue();
        }
        return new Counter(charArray, intArray);
    }

    private static class IntegerCharPair {
        private int integerValue;
        private char charValue;

        public IntegerCharPair(int integerValue, char charValue) {
            this.integerValue = integerValue;
            this.charValue = charValue;
        }

        public int getIntegerValue() {
            return integerValue;
        }

        public char getCharValue() {
            return charValue;
        }
    }
}