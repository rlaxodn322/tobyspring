package tobyspring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public List<String> sortByLength(List<String> list){
        list.sort((o1, o2) -> o1.length() - o2.length()  );
        return list;
    }
//    public static void main(String[] args) {
//
//        List<String> scores = Arrays.asList("z", "spring","Java");
//        Collections.sort(scores, (o1, o2) -> o1.length() - o2.length()  );
//        scores.forEach(System.out::println);
//    }
}
