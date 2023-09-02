package exoptional;

import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Ex01 {

    public class Idol {
        private Leader leader;

        private String name;

        public Idol(Leader leader, String name) {
            this.leader = leader;
            this.name = name;
        }

        public Leader getLeader() {
            return leader;
        }
    }

    public class Leader {
        private String name;
        private Car car;

        public Leader(String name, Car car) {
            this.name = name;
            this.car = car;
        }

        public Car getCar() {
            return car;
        }

//        public Optional<Car> getCar() {
//            return Optional.ofNullable(car);
//        }
    }

    public class Car {
        private String name;

        public Car(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public Optional<Car> getBiggerCar(Leader l1, Leader l2) {
        // ... business logic
        return Optional.ofNullable(l1.getCar());
    }

    @Test
    public void test() {
        Car audi = new Car("audi");
        Leader karina = new Leader("karina", audi);
        Idol aespa = new Idol(karina, "aespa");

        // 1. Optional.ofNullable()
        String carName = Optional.ofNullable(aespa)
                .map(Idol::getLeader) // return Optional<Leader>
                .map(Leader::getCar)// return Optional<Car>
                .map(Car::getName) // return Optional<String>
                .orElse("unkown, something is null");

//        String carName = Optional.ofNullable(aespa)
//                .map(Idol::getLeader) // return Optional<Leader>
//                .flatMap(Leader::getCar)// return Optional<Car>
//                .map(Car::getName) // return Optional<String>
//                .orElse("unkown, something is null");

        System.out.println(carName);
    }

    @Test
    public void test2() {
        Car audi = new Car("audi");
        Leader karina = new Leader("karina", audi);

        Car ferrarri = new Car("ferrarri");
        Leader jenny = new Leader("jenny", ferrarri);

        Optional<Leader> optKarina = Optional.ofNullable(karina);
        Optional<Leader> optJenny = Optional.ofNullable(jenny);

        optKarina.flatMap(k ->
                        optJenny.flatMap(j ->
                                getBiggerCar(k, j)))
                .map(Car::getName)
                .ifPresent(System.out::println);


    }
}
