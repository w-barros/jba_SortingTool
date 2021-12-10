package sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortIntegers {
    public static int totalNumbers(ArrayList<Integer> list) {
        return list.size();
    }

    public static ArrayList<Integer> sortedData(ArrayList<Integer> list) {
        Collections.sort(list);
        return list;
    }

    public static void run() {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            list.add(number);
        }
        if (!list.isEmpty()) {
            Collections.sort(list);
            System.out.println("Total numbers: "+ SortIntegers.totalNumbers(list) + ".");
            System.out.println("Sorted data: " + list.toString().replace("[","").replace("]","").replace(",",""));

        }
    }

}