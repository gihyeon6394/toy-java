package demethod;

/**
 * @Author : kgh
 * @Date : 2021-07-29
 * @Description : Domain class의 공통 기능을 interface로 뽑아냄
 * @Version : 1.0
 */
public interface CommonActing {

    void whenCreated();

    void whenUpdt();

    void whenDel();

    void whenCopied();

    void whenMoved();

    default void whenRenamed() {
        System.out.println("whenRenamed");
    }
}

