# Generics

## 배경

- 컴파일 버그는 일찍이 탐지되기 때문에 디버그가 쉽다.
- 런타임 버그는 나중에 발견되기 때문에 디버그가 어렵다.
- 제네릭은 컴파일 타임에 타입을 체크하기 때문에 런타임 버그를 줄여준다.

## 제네릭을 왜 쓰는가

### formal parameter vs type parameter

- 간단히 말해서, 제네릭은 클래스<sup>인터페이스, 메서드</sup>를 정의할 때 타입 파라미터를 사용할 수 있게 해준다.
- 타입 파라미터는 같은 코드에 다른 타입의 input을 받을 수 있게 해준다.
- 다른 점은 formal paramter는 value를 받고, 타입 파라미터는 type을 받는다는 것이다.

### generic code vs non-generic code

- 컴파일 타임의 타입 체크
- 캐스팅 제거
- 개발자가 제네릭 알고리즘을 구현할 수 있음
    - 다른 타입의 컬렉션, 커스터마이즈 가능, 타입 안정성, 코드 가독성

### non-generic code 의 불안정성

```java
public class Foo {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.set("hello");
        Integer val = (Integer) box1.get(); // java.lang.ClassCastException
    }
}

public class Box {
    private Object object;

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }
}
```

## 제네릭

```java
public class Foo {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<Integer>();
        box1.set("hello"); // Compile Error  Required type: Integer
    }
}

public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

```

### 제네릭 포맷

````
class name<T1, T2, ..., Tn> { /* ... */ }
````

### Type Parameter Naming Conventions

- single character
- uppercase letter

#### Ex.

- E - Element (used extensively by the Java Collections Framework)
- K - Key
- N - Number
- T - Type
- V - Value
- S,U,V etc. - 2nd, 3rd, 4th types

### Multiple Type Parameters

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {this.key = key;this.value = value;}

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}
```

## RawTypes 은 지양하라

### RayTypes?

- 제네릭 클래스를 인스턴스화 할 때 타입 매개변수 <sup>type argument</sup>를 생략하는 것

````
Box rawBox = new Box<>();
````

### RawTypes 은 제네릭의 타입 체크를 bypass 한다


```java
public class Foo {
  public static void main(String[] args) {
    Box rawBox = new Box();           // rawBox is a raw type of Box<T>
    Box<Integer> intBox = rawBox;     // warning: Unchecked assignment: '...Box' to '...Box<java.lang.Integer>'

    Box<String> stringBox = new Box<>();
    Box rawBox = stringBox;
    rawBox.set(8);  // warning: Unchecked call to 'set(T)' as a member of raw type '...Foo'
  }
}

```

### Unchecked Error Messages 자세히 보기

```java
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
```

위 코드를 컴파일하면 주석과 같은 메시지를 출력한다.  
이 떄 -Xlint:unchecked 컴파일 옵션을 추가하면 디테일하게 아래 메시지를 확인할 수 있다.  

```bash
java: unchecked conversion
  required: generics.WarningDemo.Box<java.lang.Integer>
  found:    generics.WarningDemo.Box
```

@SuppressWarnings 을 사용하여 모든 unchecked 경고를 컴파일 타임에서 무시할 수 있다.

````
@SuppressWarnings("unchecked")
````

## 참고

- https://docs.oracle.com/javase/tutorial/java/generics/index.html
- https://docs.oracle.com/javase/tutorial/extra/generics/index.html
