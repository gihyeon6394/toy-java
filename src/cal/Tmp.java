package cal;

import java.time.LocalDate;

public class Tmp {

    public static void main(String[] args) {
        int twoYearsAgo = LocalDate.now()
                .minusYears(2)
                .getYear();

        String twoYearsAgoStr = String.valueOf(twoYearsAgo);

        System.out.println("this year: " + LocalDate.now().getYear()); // 2024
        System.out.println("two years ago: " + twoYearsAgo); // 2022
    }
}
