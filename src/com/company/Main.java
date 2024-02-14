package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
       public static void main(String[] args) throws FileNotFoundException {
              List<List<String>> records = new ArrayList<>();
              Scanner scanner = new Scanner(new File("./src/Задача.csv"));
              while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
              }
              scanner.close();
              for (List<String> record : records) {
                System.out.println("City="+record);
              }
       }
    private static List<String> getRecordFromLine(String s) {
        List<String> values = new ArrayList<String>();
        String[] errors = new String[]{"name=", "region=", "district=", "population=", "foundation="};
        try (Scanner rowScanner = new Scanner(s).useDelimiter(",")) {
            while (rowScanner.hasNext()) {
                if (rowScanner.hasNext(".*,*.")) {
                    values.addAll(Arrays.asList(rowScanner.next().split(";")));
                    values.remove(0);
                } else {
                values.add(rowScanner.next());
                }
            }
            for (int i = 0; i < values.size(); i++) {
                values.set(i, errors[i] + values.get(i));
            }
        }
        return values;
    }
    }

