import java.util.Scanner;

public class AddArrayElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = {10, 4, 6, 7, 8};
        System.out.println("Integer numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
        System.out.println("Enter a number: ");
        int x = input.nextInt();
        System.out.println("Enter position (From 0 to N): ");
        int index = input.nextInt();
        if (index <= 1 && index >= numbers.length - 1) {
            System.out.println("Cant");
        }
    }
}
