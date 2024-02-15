package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;


public class Main {
       public static void main(String[] args) throws FileNotFoundException {
           List<List<String>> records = new ArrayList<>();
           Scanner scanner = new Scanner(new File("./src/Задача.csv"));
           while (scanner.hasNextLine()) {
               records.add(getRecordFromLine(scanner.nextLine()));
           }
           Map<String, Integer> countMap = new HashMap<>();
           for (List<String> list : records) {
               if (list.size() > 1) {
                   String value = list.get(1);
                   countMap.put(value, countMap.getOrDefault(value, 0) + 1);
               }
           }
           for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
               System.out.println(entry.getKey() + " - " + entry.getValue());
           }
           scanner.close();
       }

    private static List<String> getRecordFromLine(String s) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(s).useDelimiter(",")) {
            while (rowScanner.hasNext()) {
                if (rowScanner.hasNext(".*,*.")) {
                    values.addAll(Arrays.asList(rowScanner.next().split(";")));
                    values.remove(0);
                } else {
                values.add(rowScanner.next());
                }
            }
        }
        return values;
    }
}

