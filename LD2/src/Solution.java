import java.util.Scanner;

public class Solution {

    static long superDigit(long x)
    {
        if (x == 0)
            return 0;
        return (x % 9 == 0) ? 9 : (x % 9);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int i = sc.nextInt();
        long  result = superDigit(i);
        System.out.println(result);
    }
}
