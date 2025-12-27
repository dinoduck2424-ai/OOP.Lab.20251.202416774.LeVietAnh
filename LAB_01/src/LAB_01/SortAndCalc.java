package LAB_01;
import java.util.Scanner;

public class SortAndCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) return;

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (a[i] > a[j]) {
                    int t = a[i]; a[i] = a[j]; a[j] = t;
                }

        int sum = 0;
        for (int x : a) {
            System.out.print(x + " ");
            sum += x;
        }
        System.out.println("\nSum = " + sum);
        System.out.println("Average = " + (double) sum / n);
        sc.close();
    }
}
