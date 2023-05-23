package generics;

public class WarningDemo {
    public static void main(String[] args) {
        Box<Integer> bi;
        bi = createBox(); // Unchecked assignment: 'generics.WarningDemo.Box' to 'generics.WarningDemo.Box<java.lang.Integer>'
        //  uses unchecked or unsafe operations.
        // java: Recompile with -Xlint:unchecked for details.
    }

    static Box createBox() {
        return new Box();
    }

    public static class Box<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }
}
