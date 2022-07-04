package selfPratice;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamTest {
    public static void main(String[] args) {

        Stream<int[]> stream = IntStream.rangeClosed(1, 5)
                .filter(b -> Math.sqrt(b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{b, (int) Math.sqrt(1 + b * b)});

        IntStream.rangeClosed(1, 5)
                .filter(b -> Math.sqrt(b*b) % 1 == 0)
                .mapToObj(b -> new int[]{ b, (int) Math.sqrt(1+ b* b)});
    }
}
