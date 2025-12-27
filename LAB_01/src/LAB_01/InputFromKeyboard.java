package LAB_01;
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Height: ");
        double height = sc.nextDouble();
        System.out.println(name + " - " + age + " - " + height);
        sc.close();
    }
}
