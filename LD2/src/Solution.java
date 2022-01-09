import java.util.Scanner;

public class Solution {

    private static long superDigit(long x)
    {
        if (x < 10) {
            return x;
        }else {
            long Sum = (x % 10) + superDigit(x / 10);
            return superDigit(Sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        long i = sc.nextInt();
        long  result = superDigit(i);
        System.out.println(result);
    }
}