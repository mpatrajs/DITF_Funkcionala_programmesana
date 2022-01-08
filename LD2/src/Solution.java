import java.util.Scanner;

public class Solution {

    private static long superDigit(long x)
    {
        if (x < 10) {
            return x;
        }else {
            int Sum = 0;
            do {
                Sum += x % 10;
                x = x / 10;
            }while (x > 0);
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
