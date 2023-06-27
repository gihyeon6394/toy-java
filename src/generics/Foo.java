package generics;

import java.util.ArrayList;
import java.util.List;

public class Foo {

    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("hello");
        String s1 = (String) list1.get(0); // casting needed

        List<String> list2 = new ArrayList<String>();
        list2.add("hello");
        String s2 = list2.get(0);   // no cast

        Box box1 = new Box();
        box1.set("hello");
//        Integer int1 = (Integer) box1.get(); // java.lang.ClassCastException

        BoxGeneric<Integer> box2 = new BoxGeneric<Integer>();
        // box2.set("hello"); // Compile Err  Required type: Integer


        BoxGeneric rawBox = new BoxGeneric();

        BoxGeneric<String> strBox = new BoxGeneric<String>();
        rawBox = strBox;              // OK

        BoxGeneric rawBox1 = new BoxGeneric();           // rawBox is a raw type of Box<T>
        BoxGeneric<Integer> intBox = rawBox1;     // warning: unchecked conversion

        BoxGeneric rawBox2 = new BoxGeneric();           // rawBox is a raw type of Box<T>
        BoxGeneric<Integer> intBox2 = rawBox2;     // warning: unchecked conversion

        BoxGeneric<String> strBox3 = new BoxGeneric<>();
        BoxGeneric rawBox3 = strBox3;     // warning: unchecked conversion
        rawBox3.set(119327);
        String val = String.valueOf(rawBox3.get());
        System.out.println(val);

        generics.Pair<Integer, String> p1 = new generics.Pair<>(1, "world");
        generics.Pair<Integer, String> p2 = new generics.Pair<>(2, "world");
        System.out.println(generics.Util.compare(p1, p2));

        testTypeParam();
        testTypeParamWithGeneric();

    }

    private static void testTypeParamWithGeneric() {

    }

    /*public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e > elem)  // compiler error : Operator '>' cannot be applied to 'T', 'T'
                ++count;
        return count;
    }*/

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            // if (e > elem)  // compiler error : Operator '>' cannot be applied to 'T', 'T'
            if(e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    private static void testTypeParam() {
        // printTypeParameter(1);
        // printTypeParameter("이건 안되지");

    }

    /**
     * non-Generic class
     * getter가 Object를 리턴하기 때문에 기본형이 아니면 무엇이든 object 변수에 할당이 가능해진다.
     * object 가 어떤 타입으로 쓰일지는 런타임에 결정된다.
     * <p>
     * object 변수에 Integer를 할당하고 Integer를 빼서 쓰다가,
     * String으로 캐스팅한다면 런타임에러가 난다.
     */
    public static class Box {
        private Object object;

        public void set(Object object) {
            this.object = object;
        }

        public Object get() {
            return object;
        }
    }

    public static class BoxGeneric<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }


    public interface Pair<K, V> {
        public K getKey();

        public V getValue();
    }

    public class OrderedPair<K, V> implements Pair<K, V> {

        private K key;
        private V value;

        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    /**
     * Bounded Type Parameters
     */

    public static <U extends Number> void printTypeParameter(U u) {
        System.out.println(u.getClass().getName());
        System.out.println(u);

    }

}
