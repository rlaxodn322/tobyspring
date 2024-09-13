package tobyspring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
//        List<Integer> scores = Arrays.asList(1,5,2,7,3);
//        Collections.sort(scores);
//        scores.forEach(System.out::println);
        List<String> scores2 = Arrays.asList("z", "spring","Java");
        Collections.sort(scores2, (o1, o2) -> o1.length() - o2.length()  );
        scores2.forEach(System.out::println);
    }
}
