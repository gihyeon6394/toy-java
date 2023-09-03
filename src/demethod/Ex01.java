package demethod;

public class Ex01 {
    public interface Dancing{
        default void dance(){
            System.out.println("Dancing");
        }
    }

    public interface Singing{
        default void sing(){
            System.out.println("Singing");
        }
    }

    public interface Acting{

    }

    public class Idol implements Dancing, Singing, Acting{
        void act(){

        }
    }

    public class Actor implements Acting{
    }

    public static void main(String[] args) {
        Idol idol = new Ex01().new Idol();
        idol.act(); // print "Acting"
        idol.dance(); // print "Dancing"
        idol.sing(); // print "Singing"

    }
}
