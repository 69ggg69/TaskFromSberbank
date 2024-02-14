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
              int[] arr = new int[records.size()];
                for (int i = 0; i < records.size(); i++) {
                    arr[i] = parseInt(records.get(i).get(3));
                }
           int maxAt = 0;
                int max = arr[0];
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                        maxAt = i;
                    }
                }
           for (int i = 0; i < arr.length; i++) {
               maxAt = arr[i] > arr[maxAt] ? i : maxAt;
           }
           scanner.close();
           System.out.println(maxAt + "="+max);
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

