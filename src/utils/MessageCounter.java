package utils;

import java.util.Arrays;

public class MessageCounter {
    public static Counter analyze(String messageInput) {
        int count[] = new int[256];
        int length = messageInput.length();

        //Initialize count array index
        for (int i = 0; i < length; i++)
            count[messageInput.charAt(i)]++;
        //Initialize array of the messageInput length
        char ch[] = new char[length];
        char uniqueChar[] = new char[0];
        int uniqueCharCount[] = new int[0];

        for (int i = 0; i < length; i++)
        {
            ch[i] = messageInput.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++)
            {
                if (messageInput.charAt(i) == ch[j])
                    find++;
            }

            if (find == 1){
                uniqueChar = Arrays.copyOf(uniqueChar, uniqueChar.length+1);
                uniqueCharCount = Arrays.copyOf(uniqueCharCount, uniqueCharCount.length+1);
                uniqueChar[uniqueChar.length-1] = messageInput.charAt(i);
                uniqueCharCount[uniqueCharCount.length-1] = count[messageInput.charAt(i)];
            }
        }

//        for(int i = 0; i<uniqueChar.length; i++){
//            System.out.println(uniqueChar[i] + " - " + uniqueCharCount[i]);
//        }

        return Sorter.analyze(uniqueCharCount, uniqueChar);
    }
}
