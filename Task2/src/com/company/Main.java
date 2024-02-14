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
           Comparator<List<String>> COMPARATOR_BY_NAME = new Comparator<List<String>>(){
               @Override
               public int compare(List<String> o1, List<String> o2) {
                   return o1.get(0).compareTo(o2.get(0));
               }
           };
              Comparator<List<String>> COMPARATOR_BY_PRIORITY = new Comparator<List<String>>() {
                  @Override
                  public int compare(List<String> o1, List<String> o2) {
                      return o1.get(2).compareTo(o2.get(2));
                  }
              };
            records.sort(COMPARATOR_BY_PRIORITY.thenComparing(COMPARATOR_BY_NAME));
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

