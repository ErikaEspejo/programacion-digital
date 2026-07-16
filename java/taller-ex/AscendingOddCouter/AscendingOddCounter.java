import java.util.Scanner;

public class AscendingOddCounter {
    public static void main(String[] args) {
        int odd_counter = 0;
        int new_number = read_new_number();
        int prev_number = new_number;

        while (new_number >= prev_number) {
            prev_number = new_number;
            odd_counter = increase_odd_counter(new_number, odd_counter);
            new_number = read_new_number();
        }

        System.out.println("Ingresaste " + odd_counter + " números impares.");
    }

    public static int read_new_number() {
        System.out.print("Ingresa un numero: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int increase_odd_counter(int new_number, int odd_counter) {
        if (new_number % 2 != 0) {
            odd_counter++;
        }
        return odd_counter;
    }
}