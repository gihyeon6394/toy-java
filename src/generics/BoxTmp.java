package generics;

public class BoxTmp<T> {
    private T t;

    public BoxTmp() {
    }

    public BoxTmp(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    public void printVale() {
        System.out.println(t);
    }
}
