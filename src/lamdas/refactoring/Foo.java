package lamdas.refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Foo {

    public static void main(String[] args) {
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello World");
//            }
//        };
//
//        Runnable r2 = () -> System.out.println("Hello World");


    }

    @Test
    public void testFeed(){

        Feed feed = new Feed();
        feed.registerObserver(new FanAespa());
        feed.registerObserver(new FanNewJeans());
        feed.notifyObservers("Aespa is the best!!");
    }

    @Test
    @DisplayName("람다로 대체")
    public void testFeedLamda(){

        Feed feed = new Feed();

        // fansAespa
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("Aespa")) {
                sendTweet("To. Aespa Fans " + tweet);
            }
        });

        // fansNewJeans
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("NewJeans")) {
                sendTweet("To. NewJeans Fans " + tweet);
            }
        });

        feed.notifyObservers("Aespa is the best!!");
    }

    interface Observer {
        void notify(String tweet);
    }



    class FanAespa implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("Aespa")) {
                sendTweet("To. Aespa Fans " + tweet);
            }
        }
    }


    class FanNewJeans implements Observer {
        @Override
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("NewJeans")) {
                sendTweet("To. NewJeans Fans " + tweet);
            }
        }
    }

    interface Subject {
        void registerObserver(Observer o);

        void notifyObservers(String tweet);
    }

    class Feed implements Subject {
        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void registerObserver(Observer o) {
            this.observers.add(o);
        }

        @Override
        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.notify(tweet));
        }
    }

    private void sendTweet(String s) {
        System.out.println(s);
    }
}
