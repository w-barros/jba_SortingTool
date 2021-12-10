package sorting;

import kotlin.Pair;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongSorting {
    public static int totalNumbers (ArrayList<Long> list) {
        return list.size();
    }

    public static Long highestNumber (ArrayList<Long> list) {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static int highestFrequency (ArrayList<Long> list) {
        Collections.sort(list);
        Long highest =  list.get(list.size() - 1);
        return Collections.frequency(list,highest);
    }

    public static int highestPercentage (ArrayList<Long> list) {
        double result = ((double) LongSorting.highestFrequency(list) / list.size() ) * 100;
        return (int) result;
    }

    public static int itemPercentage (ArrayList<Long> list, Long item) {
        double result = ((double) Collections.frequency(list,item) / list.size() ) * 100;
        return (int) result;
    }

    public static void run () {
        ArrayList<Long> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextInt();
            list.add(number);
        }
        if (!list.isEmpty()) {
            System.out.println("Total numbers: " + LongSorting.totalNumbers(list) + ".");
            System.out.println("The greatest number: " + LongSorting.highestNumber(list) + "(" + LongSorting.highestFrequency(list) + " time(s), " + LongSorting.highestPercentage(list) + "%).");
        } else {
            System.out.println("Total numbers: 0");
            System.out.println("The greatest number:  (0 time(s), 0%).");
        }
    }
    public static class SortByLex implements Comparator<PairObject> {


        @Override
        public int compare(PairObject p1, PairObject p2) {
            int result = 0;
            if (Integer.parseInt(p1.getValue()) < Integer.parseInt(p2.getValue())) {
                result = -1;} else if (Integer.parseInt(p2.getValue()) > Integer.parseInt(p1.getValue())) {
                result = 1;} else if (Integer.parseInt(p1.getValue()) == Integer.parseInt(p2.getValue())) {
                result = Integer.parseInt(p1.getKey()) > Integer.parseInt(p2.getKey()) ? 1
                        : Integer.parseInt(p2.getKey()) > Integer.parseInt(p1.getKey()) ? -1 : 0;
            }
            return result;
        }
    }

    public static TreeMap<String, String> createTreeMap (ArrayList<Long> list) {
        TreeMap<String, String> map = new TreeMap<>();
        for (Long item: list
             ) {
                    String value = String.valueOf(Collections.frequency(list, item));
                map.put(item.toString(), value);
        }
        return map;
    }

    public static void runByCount () {
        ArrayList<Long> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            list.add(number);
        }
        if (!list.isEmpty()){
            TreeMap<String, String> map = createTreeMap(list);
           //
            List<PairObject> listPair = new ArrayList<>();
            for (var entry: map.entrySet()) {
                PairObject pair = new PairObject();
                pair.setKey(entry.getKey());
                pair.setValue(entry.getValue());
               listPair.add(pair);
            }
            //
            Collections.sort(listPair,new SortByLex());
            //

            System.out.println("Total numbers: " + LongSorting.totalNumbers(list) + ".");
            for (PairObject pair: listPair) {
                    System.out.println(pair.getKey() + ": " + pair.getValue() + " time(s), " + itemPercentage(list, Long.parseLong(pair.getKey())) + "%");
            }
        }

    }

    public static void runNaturally () {
        ArrayList<Long> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            list.add(number);
        }
        if (!list.isEmpty()) {
            Collections.sort(list);
            System.out.println("Total numbers: " + LongSorting.totalNumbers(list) + ".");
            System.out.println("Sorted data: " + list.toString().replace("[","").replace("]","").replace(",",""));
        }
    }
}