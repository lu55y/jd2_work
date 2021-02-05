package it.academy;

import java.util.List;
import java.util.Objects;

public class Average {


    public static Double getAverage(List<Integer> numbers){
        if (numbers == null)return 0.0;
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(value -> value)
                .average()
                .orElse(0.0)
                ;
    }


}
