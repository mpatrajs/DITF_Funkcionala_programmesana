import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PerfectNumber {

    private static final State DEFAULT_STATE = State.PERFECT;

    private enum State {
        DEFICIENT, PERFECT, ABUNDANT
    }

    public static Set<Integer> divisors(int n) {
        Set<Integer> divisors = new HashSet<>();
        IntStream.range(1, n).filter(i -> n % i == 0).forEach(divisors::add);
        return divisors;
    }

    public static State process(int n) {
        State process;
        Set<Integer> divisors = divisors(n);
        int sum = divisors.stream().reduce(0, Integer::sum);

        Predicate<Integer> isOneOrLessThanN = (sumValue) -> sumValue == 1 || sumValue < n;
        Predicate<Integer> isMoreThanN = (sumValue) -> sumValue > n;

        Map<State, Predicate<Integer>> predicates = new HashMap<>();
        predicates.put(State.DEFICIENT, isOneOrLessThanN);
        predicates.put(State.ABUNDANT, isMoreThanN);

        process = predicates.entrySet().stream()
                .filter(entry -> entry.getValue().test(sum))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(DEFAULT_STATE);

        System.out.println(process);
        return process;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int i = sc.nextInt();
        process(i);
    }
}