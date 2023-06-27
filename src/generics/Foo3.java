package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Type Inferrence : 타입 추론
 */
public class Foo3 {
    public static void main(String[] args) {
        Serializable s = pick("d", new ArrayList<String>());


        ArrayList<BoxTmp<Integer>> listOfIntegerBoxes = new ArrayList<>();
        /**
         *
         * 첫번째 매개변수가 Integer 타입이라는 걸 생략해도 컴파일러가 Integer 타입으로 추론해냄
         * */
        addBox(Integer.valueOf(10), listOfIntegerBoxes);
        addBox(Integer.valueOf(20), listOfIntegerBoxes);
        addBox(Integer.valueOf(30), listOfIntegerBoxes);
        outputBoxes(listOfIntegerBoxes);

        java.util.Map<String, List<String>> myMap1 = new HashMap<String, List<String>>(); // Explicit type argument String, List<String> can be replaced with <>
        java.util.Map<String, List<String>> myMap2 = new HashMap<>();
        java.util.Map<String, List<String>> myMap3 = new HashMap(); // / unchecked conversion warning

        new MyClass<Integer>("");
        MyClass<Integer> myObject = new MyClass<>(""); // X에 Integer 유추, T에 String 유추

        Collections.emptyList();

        /**
         * return type이 List<T>이나, 타입을 명시하지 않아도 Stirng으로 추론
         * 이떄 Strting 타입을 Target Types라고 함
         * */
        List<String> list1 = Collections.emptyList();
        List<String> list2 = Collections.<String>emptyList();

        doWithStringList(Collections.emptyList());
    }

    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static <U> void addBox(U u, List<BoxTmp<U>> boxes) {
        BoxTmp<U> box = new BoxTmp<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(List<BoxTmp<U>> boxes) {
        int counter = 0;
        for (BoxTmp<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" + boxContents.toString() + "]");
            counter++;
        }
    }

    private static class MyClass<X> {
        <T> MyClass(T t) {
            System.out.println(t);
        }
    }

    private static void doWithStringList(List<String> strList) {
        //do something with string list
    }

}
