package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntegerSorting {
    public static int totalNumbers (ArrayList<Integer> list) {
        return list.size();
    }

    public static int highestNumber (ArrayList<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static int highestFrequency (ArrayList<Integer> list) {
        Collections.sort(list);
        int highest =  list.get(list.size() - 1);
        return Collections.frequency(list,highest);
    }

    public static int highestPercentage (ArrayList<Integer> list) {
        return (highestFrequency(list) / list.size() ) * 100;
    }

    public static void run () {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            list.add(number);
        }
        System.out.println("Total numbers: " + IntegerSorting.totalNumbers(list) + ".");
        System.out.println("The greatest number: " + IntegerSorting.highestNumber(list) + "(" + IntegerSorting.highestFrequency(list) + " time(s), " + IntegerSorting.highestPercentage(list) + "%).");
    }
}
