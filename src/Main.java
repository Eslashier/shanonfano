import utils.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Shannon-Fano program - Actividad eje 3 - Fundación Universitaria del Área Andina");
        System.out.println("Please input a string");
        Scanner scanner = new Scanner(System.in);
        String messageInput = scanner.nextLine();

        Counter result = MessageCounter.analyze(messageInput);

        Float[] probability = Probability.analyze(result);

        ShannonFano shannonFano = new ShannonFano();

        shannonFano.encode(result.getUniqueChar(), result.getUniqueCharCount());
        Map<Character, String> encodingTable = shannonFano.getEncodingTable();

        Map.Entry<Character, String>[] entries = encodingTable.entrySet().toArray(new Map.Entry[0]);

        for(int i = 0; i<result.getUniqueCharCount().length; i++){
            System.out.println(entries[i].getKey() + " - " + result.getUniqueCharCount()[i] +" - " + probability[i] +" - " + entries[i].getValue());
        }

    }
}


