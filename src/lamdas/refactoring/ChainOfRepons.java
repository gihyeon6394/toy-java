package lamdas.refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfRepons {

    public abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor; // 후임자

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r); // 후임자에게 전달
            }
            return r;
        }

        abstract protected T handleWork(T input);
    }

    public class HeaderTextProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String text) {
            return "그룹명은 소문자에서 대문자로 변환됩니다. \n" + text;
        }
    }

    public class ToUpperCaseProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String text) {
            return text.replaceAll("aespa", "AESPA");
        }
    }


    @Test
    @DisplayName("Chain of Responsibility")
    public void tst() {
        ProcessingObject<String> headerTextProcessing = new HeaderTextProcessing();
        ProcessingObject<String> toUpperCaseProcessing = new ToUpperCaseProcessing();
        headerTextProcessing.setSuccessor(toUpperCaseProcessing);
        String result = headerTextProcessing.handle("aespa is the best!");
        System.out.println(result);
    }

    @Test
    @DisplayName("Chain of Responsibility lamda")
    public void tstLamda(){
        UnaryOperator<String> headerProcessing = (String text) -> "그룹명은 소문자에서 대문자로 변환됩니다. \n" + text;
        UnaryOperator<String> toUpperCaseProcessing = (String text) -> text.replaceAll("aespa", "AESPA");
        Function<String, String> pipeline = headerProcessing.andThen(toUpperCaseProcessing);
        String result = pipeline.apply("aespa is the best!");
        System.out.println(result);
    }


}
