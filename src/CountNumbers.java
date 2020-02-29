import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountNumbers {
    public static void main(String[] args) {

        String fileName = "numbers.txt";
        try {
            Map<Integer, Integer> numbersMap = createMapFromFile(fileName);
            showNumbersMap(numbersMap);
        } catch (FileNotFoundException e) {
            System.out.println("Plik " + fileName + " nie istnieje!");
        }
    }

    private static Map<Integer, Integer> createMapFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        Map<Integer, Integer> numMap = new TreeMap<>();

        while (sc.hasNextLine()) {
            Integer number = sc.nextInt();
            putNumberInMap(number, numMap);
        }
        return numMap;
    }

    private static void putNumberInMap(Integer number, Map<Integer, Integer> numMap) {
        if(numMap.containsKey(number)){
            int value = numMap.get(number);
            numMap.put(number,value+1);
        }
        else{
            numMap.put(number,1);
        }
    }

    private static void showNumbersMap(Map<Integer, Integer> numMap) {
        for (Integer key:numMap.keySet()) {
            System.out.println(key + " – liczba wystąpień: " + numMap.get(key));
        }
    }
}
