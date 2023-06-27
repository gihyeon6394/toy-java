package generics;

import java.util.Arrays;
import java.util.List;

public class Foo4 {

    public static void main(String[] args) {
//        doSomething(new ArrayList<Integer>());
//        doSomething(new ArrayList<Double>());

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        // loopList1(list1);
        loopList2(list1);

        List<String> list2 = Arrays.asList("one", "two", "three");
        loopList2(list2);
        loopList1(Arrays.asList(1, 2, 3, 4));
        loopList1(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        loopList1(Arrays.asList("one", "two", "three", "four"));
        // loopList2(Arrays.asList(1, 2, 3, 4));
    }

    public static void doSomething(List<? extends Number> numbers) {
        System.out.println(numbers);
    }

    public static void loopList1(List<Object> list) {
        for (Object obj : list) {
            System.out.println(obj + " value 1");
        }
    }

    public static void loopList2(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj + " value 2");
        }
    }
}
