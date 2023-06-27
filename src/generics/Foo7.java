package generics;

import java.util.ArrayList;
import java.util.List;

public class Foo7 {
    void ex1(List<?> list) {
        // list.set(0, list.get(0)); // java: incompatible types: java.lang.Object cannot be converted to capture#1 of ?
        ex2(list);
    }

    private <T> void ex2(List<T> list) {
        list.set(0, list.get(0));
    }

    void swapFirstIdx(List<? extends Number> list1, List<? extends Number> list2) {
        Number tmp = list1.get(0);
        // list1.set(0, list2.get(0)); // java: incompatible types: java.lang.Number cannot be converted to capture#1 of ? extends java.lang.Number
        // list2.set(0, tmp); // java: incompatible types: java.lang.Number cannot be converted to capture#2 of ? extends java.lang.Number
    }


    public static void main(String[] args) {
        List<EvenNumber> evenNumbers = new ArrayList<>();
        List<? extends NaturalNumber> naturalNumbers = evenNumbers;
        // naturalNumbers.add(new NaturalNumber(35)); // java: incompatible types: generics.Foo7.NaturalNumber cannot be converted to capture#1 of ? extends generics.Foo7.NaturalNumber

        naturalNumbers.add(null);
        // naturalNumbers.add(new EvenNumber(35));
    }

    private static class NaturalNumber {
        private int i;

        public NaturalNumber(int i) {
            this.i = i;
        }
    }

    private static class EvenNumber extends NaturalNumber {

        public EvenNumber(int i) {
            super(i);
        }
    }
}

