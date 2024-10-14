package tobyspring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    @Test
    void Test(){
        //준비
        Sort sort = new Sort();
        //실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        //검증
        Assertions.assertThat(list).isEqualTo(List.of("f b", "aa"));
    }
}
