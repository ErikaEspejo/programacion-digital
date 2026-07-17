import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        try {
             Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa un número: ");
            Integer x = scanner.nextInt();

            scanner.close();

            if(x >= 0 ){
                System.out.println(fibonacci(x));
            } else {
                System.out.println("El valor ingresado no es válido.");
            }
        
        } catch(Exception e) {
            System.out.println("Error, ingrese un número válido.");
        }   
    }

    public static int fibonacci(int x){
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        
        return fibonacci(x-1) + fibonacci(x-2);
    }

    
}
