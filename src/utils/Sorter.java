package utils;//package utils;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Sorter {
//    public static Counter analyze(Counter counter) {
//
//
//        char uniqueChar[] = counter.getUniqueChar();
//        int uniqueCharCount[] = counter.getUniqueCharCount();
//
//        Arrays.sort(uniqueCharCount);
//
//        for(int i=0; i<uniqueCharCount.length-1; i++){
//            for(int j=0; j<uniqueCharCount.length-i-1; j++){
//                if(uniqueCharCount[j]<uniqueCharCount[j+1]){
//                    int temp=uniqueCharCount[j];
//                    uniqueCharCount[j]=uniqueCharCount[j+1];
//                    uniqueCharCount[j+1]=temp;
//                    char temp_char=uniqueChar[j];
//                    uniqueChar[j]=uniqueChar[j+1];
//                    uniqueChar[j+1]=temp_char;
//                }
//            }
//        }
//
//
//        return new Counter(uniqueChar, uniqueCharCount);
//    }
//}


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