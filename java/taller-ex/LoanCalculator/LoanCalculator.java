import java.util.Scanner;

public class LoanCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int amount = 0;
        double monthlyInterestRate = -1;
        int months = 0;

        while (amount <= 0) {
            amount = readNewInt("monto");
        }

        while (months <= 0) {
            months = readNewInt("número de meses");
        }

        while (monthlyInterestRate < 0) {
            monthlyInterestRate = readNewDouble("tasa de interés mensual");
        }

        double totalPayment = calculateTotalPayment(amount, monthlyInterestRate, months);

        System.out.println("El pago total es: $" + totalPayment);
    }

    public static int readNewInt(String data) {
        System.out.print("Ingresa el " + data + ": ");
        return scanner.nextInt();
    }

    public static double readNewDouble(String data) {
        System.out.print("Ingresa la " + data + ": ");
        return scanner.nextDouble();
    }

    public static double calculateTotalPayment(int amount, double monthlyInterestRate, int months) {
        double totalInterest = amount * (monthlyInterestRate / 100) * months;

        return amount + totalInterest;
    }
}