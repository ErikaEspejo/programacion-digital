import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        try {
             Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa un número: ");
            Integer x = scanner.nextInt();

            scanner.close();

            System.out.println(x);

            if (x > 30) {
                System.out.println("Es un gran número");
            } else {
                System.out.println("No es lo suficientemente grande");
            } 

            while (x > 0) {
                System.out.println(x);
                x--;    
            }

        System.out.println(sumar(5,6));
        
        } catch(Exception e) {
            System.out.println("Error, ingrese un número válido.");
        }   
    }

    public static Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
