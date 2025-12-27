package LAB_01;
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month;
        do {
            System.out.print("Enter month (1-12): ");
            month = sc.nextInt();
        } while (month < 1 || month > 12);

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        int days;
        switch (month) {
            case 2:
                days = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            default:
                days = 31;
        }

        System.out.println("Number of days: " + days);
        sc.close();
    }
}
