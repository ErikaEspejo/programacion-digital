import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("   SIMULADOR DE ABORDAJE AÉREO");
        System.out.println("==================================");

        Plane selectedPlane = selectValidPlane();

        System.out.println("\nAvión seleccionado correctamente.");
        selectedPlane.showInformation();

        System.out.println("\n==================================");
        System.out.println("    REGISTRO DE TRIPULACIÓN");
        System.out.println("==================================");

        ArrayList<Person> crew = registerCrew();

        System.out.println("\n==================================");
        System.out.println("      REGISTRO DE PASAJEROS");
        System.out.println("==================================");

        ArrayList<Person> passengers = registerPassengers(
            selectedPlane.getPassengerCapacity()
        );

        System.out.println("\n==================================");
        System.out.println("     ABORDAJE DE TRIPULACIÓN");
        System.out.println("==================================");

        selectedPlane.startCrewBoarding();

        for (Person crewMember : crew) {
            selectedPlane.boardPlane(crewMember);
        }

        System.out.println("\n==================================");
        System.out.println("      ABORDAJE DE PASAJEROS");
        System.out.println("==================================");

        if (!selectedPlane.startPassengersBoarding()) {
            System.out.println(
                "No fue posible iniciar el abordaje de pasajeros."
            );

            scanner.close();
            return;
        }

        for (Person passenger : passengers) {
            selectedPlane.boardPlane(passenger);
        }

        System.out.println("\n==================================");
        System.out.println("       VALIDACIÓN DEL VUELO");
        System.out.println("==================================");

        selectedPlane.showFlightInformation();

        if (!selectedPlane.isReadyToFly()) {
            System.out.println(
                "\nEl avión no cumple las condiciones para despegar."
            );

            scanner.close();
            return;
        }

        System.out.println("\n==================================");
        System.out.println("          INICIO DEL VUELO");
        System.out.println("==================================");

        selectedPlane.startFlight();

        if (!selectedPlane.isInFlight()) {
            scanner.close();
            return;
        }

        System.out.println("\n==================================");
        System.out.println("           ATERRIZAJE");
        System.out.println("==================================");

        int flightHours = readPositiveInteger(
            "Ingrese la duración del vuelo en horas: "
        );

        selectedPlane.land(flightHours);

        System.out.println("\n==================================");
        System.out.println("       OPERACIÓN FINALIZADA");
        System.out.println("==================================");

        selectedPlane.showFlightInformation();

        scanner.close();
    }

    private static Plane selectValidPlane() {
        Plane plane = null;
        boolean validPlane = false;

        while (!validPlane) {
            System.out.println("\nSeleccione un avión:");
            System.out.println("1. Boeing 737-800 - Avianca");
            System.out.println("2. Airbus A320 - LATAM");
            System.out.println("3. Embraer E190 - Copa Airlines");

            int option = readInteger("Opción: ");

            int currentFlightHours = readNonNegativeInteger(
                "Ingrese las horas actuales del motor: "
            );

            switch (option) {
                case 1:
                    plane = createBoeing737(currentFlightHours);
                    break;

                case 2:
                    plane = createAirbusA320(currentFlightHours);
                    break;

                case 3:
                    plane = createEmbraerE190(currentFlightHours);
                    break;

                default:
                    System.out.println(
                        "La opción seleccionada no es válida."
                    );

                    continue;
            }

            validPlane = plane.isAvailableForOperation();

            if (!validPlane) {
                System.out.println(
                    "\nEl avión seleccionado no puede realizar el vuelo."
                );

                System.out.println(
                    "Seleccione otro avión o corrija las horas del motor."
                );
            }
        }

        return plane;
    }

    private static Plane createBoeing737(int currentFlightHours) {
        Engine engine = new Engine(
            "CFM56-7B-001",
            "CFM56-7B",
            30000,
            currentFlightHours
        );

        return new Plane(
            "HK-7371",
            "Boeing",
            "737-800",
            "Avianca",
            175,
            3500,
            engine
        );
    }

    private static Plane createAirbusA320(int currentFlightHours) {
        Engine engine = new Engine(
            "CFM56-5B-002",
            "CFM56-5B",
            32000,
            currentFlightHours
        );

        return new Plane(
            "HK-3202",
            "Airbus",
            "A320",
            "LATAM",
            180,
            3800,
            engine
        );
    }

    private static Plane createEmbraerE190(int currentFlightHours) {
        Engine engine = new Engine(
            "CF34-10E-003",
            "CF34-10E",
            28000,
            currentFlightHours
        );

        return new Plane(
            "HP-1903",
            "Embraer",
            "E190",
            "Copa Airlines",
            100,
            2500,
            engine
        );
    }

    private static ArrayList<Person> registerCrew() {
        ArrayList<Person> crew = new ArrayList<>();

        System.out.println("\n--- Registro del piloto ---");

        Person pilot = registerPerson(
            Person.PersonRole.PILOT
        );

        crew.add(pilot);

        System.out.println("\n--- Registro del copiloto ---");

        Person copilot = registerPerson(
            Person.PersonRole.COPILOT
        );

        crew.add(copilot);

        int flightAttendantQuantity = readPositiveInteger(
            "\n¿Cuántos auxiliares de vuelo desea registrar?: "
        );

        for (int i = 1; i <= flightAttendantQuantity; i++) {
            System.out.println(
                "\n--- Auxiliar de vuelo "
                + i
                + " ---"
            );

            Person flightAttendant = registerPerson(
                Person.PersonRole.FLIGHT_ATTENDANT
            );

            crew.add(flightAttendant);
        }

        return crew;
    }

    private static ArrayList<Person> registerPassengers(
        int passengerCapacity
    ) {
        ArrayList<Person> passengers = new ArrayList<>();

        int passengerQuantity;

        do {
            passengerQuantity = readNonNegativeInteger(
                "¿Cuántos pasajeros desea registrar?: "
            );

            if (passengerQuantity > passengerCapacity) {
                System.out.println(
                    "La cantidad supera la capacidad del avión: "
                    + passengerCapacity
                    + " pasajeros."
                );
            }

        } while (passengerQuantity > passengerCapacity);

        for (int i = 1; i <= passengerQuantity; i++) {
            System.out.println(
                "\n--- Pasajero "
                + i
                + " de "
                + passengerQuantity
                + " ---"
            );

            Person passenger = registerPerson(
                Person.PersonRole.PASSENGER
            );

            passengers.add(passenger);
        }

        return passengers;
    }

    private static Person registerPerson(
        Person.PersonRole role
    ) {
        String id = readText("Identificación: ");
        String name = readText("Nombre completo: ");
        String birthDate = readText(
            "Fecha de nacimiento: "
        );

        Person person = new Person(
            id,
            name,
            birthDate,
            role
        );

        boolean hasLuggage = readYesOrNo(
            "¿Tiene equipaje? (S/N): "
        );

        if (hasLuggage) {
            String luggageCode = readText(
                "Código del equipaje: "
            );

            double luggageWeight = readPositiveDouble(
                "Peso del equipaje en kg: "
            );

            Luggage luggage = new Luggage(
                luggageCode,
                luggageWeight
            );

            person.setLuggage(luggage);
        }

        System.out.println(
            person.getName()
            + " fue registrado como "
            + person.getRole()
            + "."
        );

        return person;
    }

    private static int readInteger(String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();

                return number;
            }

            System.out.println(
                "Debe ingresar un número entero."
            );

            scanner.nextLine();
        }
    }

    private static int readPositiveInteger(String message) {
        int number;

        do {
            number = readInteger(message);

            if (number <= 0) {
                System.out.println(
                    "El número debe ser mayor que cero."
                );
            }

        } while (number <= 0);

        return number;
    }

    private static int readNonNegativeInteger(String message) {
        int number;

        do {
            number = readInteger(message);

            if (number < 0) {
                System.out.println(
                    "El número no puede ser negativo."
                );
            }

        } while (number < 0);

        return number;
    }

    private static double readPositiveDouble(String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                scanner.nextLine();

                if (number > 0) {
                    return number;
                }

                System.out.println(
                    "El número debe ser mayor que cero."
                );
            } else {
                System.out.println(
                    "Debe ingresar un número válido."
                );

                scanner.nextLine();
            }
        }
    }

    private static String readText(String message) {
        String text;

        do {
            System.out.print(message);
            text = scanner.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println(
                    "El valor no puede estar vacío."
                );
            }

        } while (text.isEmpty());

        return text;
    }

    private static boolean readYesOrNo(String message) {
        while (true) {
            String answer = readText(message);

            if (answer.equalsIgnoreCase("S")) {
                return true;
            }

            if (answer.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println(
                "Ingrese S para sí o N para no."
            );
        }
    }
}