package generics;

import java.io.Serializable;
import java.util.ArrayList;

public class Foo2 {

    public static void main(String[] args) {
        /**
         * Object와 Integer의 is a 관계
         * Intger is a Object
         * */
        Object obj1 = new Object();
        Integer int1 = new Integer(1);
        obj1 = int1;

        // someMethod1(new Integer(1));
        // someMethod1(new Double(1.0));

        someMethod2(new Integer(2));
        someMethod2(new Double(2.0));

        /*BoxTmp<Integer> box1 = new BoxTmp<>();
        box1.setT(1);*/
        // someMethod3(new BoxTmp<Integer>(1)); // compile error

        Serializable s = pick("d", new ArrayList<String>());
    }

    static <T> T pick(T a1, T a2) {
        return a2;
    }


    public static void someMethod1(Number n) {
        System.out.println(n);
    }

    public static <T extends Number> void someMethod2(T t) {
        System.out.println(t);
    }

    public static void someMethod3(BoxTmp<Number> n) {
        System.out.println(n);
    }
}
