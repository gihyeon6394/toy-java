# Stream API <sub>since Java 8</sub>

## Stream API

- 대용량 배열, 리스트의 요소에 접근하기 위해 사용
- Stream이 아니면 반복문을 통해 접근해야함

```java
import java.util.ArrayList;
import java.util.List;

public class Foo {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(4, 15, 6, 7, 8, 9, 10, 330, 191, 3));

        // 원소가 7인 값 탐색
        for (Integer i : intList) {
            if (i == 7) {
                System.out.println("found 7");
            }
        }

        // 스트림을 사용하여 원소가 7인 값 탐색
        intList.stream().filter(i -> i == 7).forEach(i -> System.out.println("found 7"));

    }
}
```

## Stream API 특징

- 내부 반복 사용 <sup>internal iteration</sup>
    - 반복문을 사용하지 않고 내부에서 반복을 처리
- 컬렉션과 달리 스트림은 재사용 불가
- 스트림은 원본 데이터 타입 변경 안함
- 
