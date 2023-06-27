package lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Foo {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(4, 15, 6, 7, 8, 9, 10, 330, 191, 3));

        // 람다를 사용하여 사용
        intList.stream().filter(i -> i == 7).forEach(i -> System.out.println("found 7"));

        // 익명클래스를 사용
        intList.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 7;
            }
        }).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("found 7");
            }
        });

    }
}
