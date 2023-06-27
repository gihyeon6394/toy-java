package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Foo {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(4, 15, 6, 7, 8, 9, 10, 330, 191, 3));

        // 원소가 7인 값 탐색
        for (Integer i : intList) {
            if (i == 7) {
                System.out.println("found 7");
            }
        }

        // 스트림을 사용하여 원소가 7인 값 탐색
        intList.stream().filter(i -> i == 7).forEach(i -> System.out.println("found 7"));

        intList.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 7;
            }
        });

    }
}
