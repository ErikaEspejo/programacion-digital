import java.util.Scanner;

public class CombinatoricsCalculator {
    public static void main(String[] args) {
        int n = read_new_number();
        int r = read_new_number();
        
        if (n < 0 || r < 0) {
            System.out.println("No se ingresaron números válidos para el cálculo.");
        } else if (n < r) {
            System.out.println("No se puede calcular la combinatoria, ya que n es menor que r.");
        } else {
            calculate_combinatoric_results(n, r);
        }
    }

    public static int read_new_number() {
        System.out.print("Ingresa un numero: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static int calculate_combinatoric(int n_factorial, int r_factorial, int n_minus_r_factorial) {
        return n_factorial / (r_factorial * n_minus_r_factorial);
    }

    public static int calculate_permutation(int n_factorial, int r_factorial) {
        return n_factorial / r_factorial;
    }

    public static void calculate_combinatoric_results(int n, int r) {
        int n_factorial = factorial(n);
        int r_factorial = factorial(r);
        int n_minus_r_factorial = factorial(n - r);

        int combinatoric_result = calculate_combinatoric(n_factorial, r_factorial, n_minus_r_factorial);
        int permutation_result = calculate_permutation(n_factorial, r_factorial);

        System.out.println("El resultado de la combinatoria C(" + n + ", " + r + ") es: " + combinatoric_result);
        System.out.println("El resultado de la permutación P(" + n + ", " + r + ") es: " + permutation_result);
    }

}