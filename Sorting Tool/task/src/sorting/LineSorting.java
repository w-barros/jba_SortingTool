package sorting;

import java.util.*;

public class LineSorting {
    public static int totalLines (ArrayList<String> list) {
        return list.size();
    }

    public static String longestLine (ArrayList<String> list) {
        Collections.sort(list, (a, b)->Integer.compare(a.length(), b.length()));
        return list.get(list.size() - 1);
    }

    public static int highestFrequency (ArrayList<String> list) {
        Collections.sort(list);
        String highest =  list.get(list.size() - 1);
        return Collections.frequency(list,highest);
    }

    public static int itemPercentage (ArrayList<String> list, String item) {
        double result = ((double) Collections.frequency(list,item) / list.size() ) * 100;
        return (int) result;
    }

    public static int highestPercentage (ArrayList<String> list) {
        double result = ((double) LineSorting.highestFrequency(list) / list.size() ) * 100;
        return (int) result;
    }

    public static void run () {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        if (!list.isEmpty()) {
            System.out.println("Total lines: " + LineSorting.totalLines(list) + ".");
            System.out.println("The longest line:");
            System.out.println(LineSorting.longestLine(list));
            System.out.println("(" + LineSorting.highestFrequency(list) + " times(s), " + LineSorting.highestPercentage(list) + "%).");
        }
        }

    public static class SortByLex implements Comparator<PairObject> {

        @Override
        public int compare(PairObject p1, PairObject p2) {
            int result = 0;
            if (Integer.parseInt(p1.getValue()) < Integer.parseInt(p2.getValue())) {
                result = -1;} else if (Integer.parseInt(p2.getValue()) > Integer.parseInt(p1.getValue())) {
                result = 1;} else if (Integer.parseInt(p1.getValue()) == Integer.parseInt(p2.getValue())) {
                result = p1.getKey().compareTo(p1.getKey());
            }
            return result;
        }
    }

    public static TreeMap<String, String> createTreeMap (ArrayList<String> list) {
        TreeMap<String, String> map = new TreeMap<>();
        for (String item: list
        ) {
            String value = String.valueOf(Collections.frequency(list, item));
            map.put(item.toString(), value);
        }
        return map;
    }

    public static void runByCount () {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
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
            Collections.sort(listPair,new WordSorting.SortByLex());
            //

            System.out.println("Total lines: " + WordSorting.totalWords(list) + ".");
            for (PairObject pair: listPair) {
                System.out.println(pair.getKey() + ": " + pair.getValue() + " time(s), " + itemPercentage(list, pair.getKey()) + "%");
            }}

    }

    public static void runNaturally () {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            list.add(line);
        }
        if (!list.isEmpty()) {
            Collections.sort(list);
            System.out.println("Total lines: " + LineSorting.totalLines(list) + ".");
            System.out.println("Sorted data:");
            for (String item: list
                 ) {
                System.out.println(item);
            }
          //  System.out.println("Sorted data: " + list.toString().replace("[","").replace("]","").replace(",",""));
        }
    }
}