package dslsample;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


class ForEachSampleTest {
    private final List<String> numbers = Arrays.asList("one","two","three");
    @Test
    void ForEachTest() {

        numbers.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    @Test
    void ForEachLambda1Test() {
        numbers.forEach(s -> System.out.println(s));
    }

    @Test
    void ForEachLambda3Test() {
        numbers.forEach(System.out::println);
    }

}