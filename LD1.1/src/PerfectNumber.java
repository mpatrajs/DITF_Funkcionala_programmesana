import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectNumber {

    private enum State {
        DEFICIENT, PERFECT, ABUNDANT
    }

    public static Set<Integer> divisors(int n) {
        Set<Integer> divisors = new HashSet();
        // fill the set with the correct values
        for (int i = 1; i < n; i++){
            if (n % i == 0){
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static State process(int n) {
        // get the set of divisors, sum'em'up and compare with n, return the rellevant State value
        State process;
        Set<Integer> divisors = divisors(n);
        if (n <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        int sum = 0;
        for (int j : divisors){
            sum += j;
        }
        if (sum == 1 || sum < n) {
            process = State.DEFICIENT;
        } else if (sum > n) {
            process = State.ABUNDANT;
        } else {
            process = State.PERFECT;
        }
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
