public class NumberColumns {
    public static void main(String[] args) {
        int ascendingNumber = 1;
        int descendingNumber = 100;

        while (ascendingNumber <= 100) {
            System.out.println(ascendingNumber + " - " + descendingNumber);

            descendingNumber--;
            ascendingNumber++;
        }
    }
}