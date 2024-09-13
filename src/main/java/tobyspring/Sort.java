package tobyspring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(1,5,2,7,3);
        Collections.sort(scores);
        scores.forEach(System.out::println);
    }
}
