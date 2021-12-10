package sorting;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws IOException {
        File file = new File("out.txt");
        file.createNewFile();
        if (Arrays.toString(args).contains("long") && Arrays.toString(args).contains("byCount")) {
            LongSorting.runByCount();
        } else if (Arrays.toString(args).contains("long") && Arrays.toString(args).contains("natural")) {
            LongSorting.runNaturally();
        } else if (Arrays.toString(args).contains("word") && Arrays.toString(args).contains("byCount")) {
            WordSorting.runByCount();
        } else if (Arrays.toString(args).contains("word") && Arrays.toString(args).contains("natural")) {
            WordSorting.runNaturally();
        } else if (Arrays.toString(args).contains("line") && Arrays.toString(args).contains("byCount")) {
            LineSorting.runByCount();
        } else if (Arrays.toString(args).contains("line") && Arrays.toString(args).contains("natural")) {
            LineSorting.runNaturally();
        } else if (Arrays.toString(args).contains("long")) {
            LongSorting.runNaturally();
        } else if (Arrays.toString(args).contains("word")) {
            WordSorting.runNaturally();
        } else if (Arrays.toString(args).contains("line")) {
            LineSorting.runNaturally();

        }
    }
}

