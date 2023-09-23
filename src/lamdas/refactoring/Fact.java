package lamdas.refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

public class Fact {
    public static Idol getIdol(String name) {
        switch (name) {
            case "Aespa":
                return new Aespa();
            case "NewJeans":
                return new NewJeans();
            default:
                throw new RuntimeException("No such idol " + name);
        }
    }

    static class Idol {
        public String getName() {
            return "Idol";
        }
    }

    static class Aespa extends Idol {
        public String getName() {
            return "Aespa";
        }
    }

    static class NewJeans extends Idol {
        public String getName() {
            return "NewJeans";
        }
    }

    @Test
    @DisplayName("팩토리로 객체 생성")
    public void testFactory() {
        Idol idol = Fact.getIdol("Aespa");
        System.out.println(idol.getName());
    }

    @Test
    @DisplayName("팩토리로 객체 생성 (람다)")
    public void testFactoryLamda() {
        Supplier<Idol> newJeans = () -> new NewJeans(); // lamda
        Supplier<Idol> aespa = Aespa::new; // method reference
    }


}
