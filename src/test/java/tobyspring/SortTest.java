package tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
     Sort sort;

    @BeforeEach
    void beforeEach(){
        sort = new Sort();
    }
    @Test
    void sort(){
        //준비

        //실행
        List<String> list = sort.sortByLength(Arrays.asList("a", "b"));
        //검증
        Assertions.assertThat(list).isEqualTo(List.of("a", "b"));
    }
//    @Test
//    void sort3Items(){
//        //준비
//        Sort sort = new Sort();
//        //실행
//        List<String> list = sort.sortByLength(Arrays.asList("aa", "bb" , "cc"));
//        //검증
//        Assertions.assertThat(list).isEqualTo(List.of("aa", "cc","bb"));
//    }
    @Test
    void sort4Items(){
        //준비

        //실행\
        List<String> list = sort.sortByLength(Arrays.asList("aa","ccc","b"));
        //검증
        Assertions.assertThat(list).isEqualTo(List.of("b","aa","ccc"));
    }

}
