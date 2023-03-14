package utils;

public class Counter {
    private char[] uniqueChar;
    private int[] uniqueCharCount;

    public Counter(char[] uniqueChar, int[] uniqueCharCount) {
        this.uniqueChar = uniqueChar;
        this.uniqueCharCount = uniqueCharCount;
    }

    public char[] getUniqueChar() {
        return uniqueChar;
    }

    public int[] getUniqueCharCount() {
        return uniqueCharCount;
    }
}
