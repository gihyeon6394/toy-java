package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foo5 {

    public static void main(String[] args) {
        List<? super Integer> objList = makeNumberList(new ArrayList<Object>());
        List<? super Integer> numberList = makeNumberList(new ArrayList<Number>());
        List<? super Integer> intList = makeNumberList(new ArrayList<Integer>());

        System.out.println(objList.toString());
        System.out.println(numberList.toString());
        System.out.println(intList.toString());

        // List<? super Integer> doubList = makeNumberList(new ArrayList<Double>()); // java: incompatible types: java.util.ArrayList<java.lang.Double> cannot be converted to java.util.List<? super java.lang.Integer>
    }

    public static List<? super Integer> makeNumberList(List<? super Integer> numbers) {
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        return numbers;
    }


}
