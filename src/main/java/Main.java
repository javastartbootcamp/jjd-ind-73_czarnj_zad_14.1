import java.awt.image.ImagingOpException;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {
        String fileName = "liczby.txt";
        Map<Integer, Integer> countedNumbers = getCountedNumbersFromFile(fileName);
        showNumbers(countedNumbers);
    }

    public static Map<Integer, Integer> getCountedNumbersFromFile(String fileName) {
        Map<Integer, Integer> countedNumbers = new TreeMap<>();
        try (var br = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                int number = Integer.parseInt(nextLine);
                if (!countedNumbers.containsKey(number)) {
                    countedNumbers.put(number, 0);
                }
                int amount = countedNumbers.get(number);
                countedNumbers.put(number, ++amount);
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
        return countedNumbers;
    }

    public static void showNumbers(Map<Integer, Integer> numbers) {
        for (Integer number : numbers.keySet()) {
            System.out.println(Integer.toString(number) + " - liczba wystąpień " + numbers.get(number));
        }
    }

}
