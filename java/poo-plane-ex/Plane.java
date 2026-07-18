import java.util.ArrayList;

public class Plane {

    private String registrationNumber;
    private String manufacturer;
    private String model;
    private String airline;
    private int passengerCapacity;
    private double maximumLuggageWeight;

    private PlaneStatus status;
    private BoardingType boardingType;

    private Engine engine;

    private ArrayList<Person> passengers;
    private ArrayList<Person> crew;
    private ArrayList<Luggage> luggage;

    private static final int NUMBER_OF_FLIGHT_CHECKS = 5;

    public enum PlaneStatus {
        AVAILABLE,
        BOARDING,
        READY_TO_FLY,
        IN_FLIGHT,
        LANDING,
        LANDED
    }

    public enum BoardingType {
        NOT_STARTED,
        CREW,
        PASSENGERS,
        FINISHED
    }

    public Plane(
        String registrationNumber,
        String manufacturer,
        String model,
        String airline,
        int passengerCapacity,
        double maximumLuggageWeight,
        Engine engine
    ) {
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.airline = airline;
        this.passengerCapacity = passengerCapacity;
        this.maximumLuggageWeight = maximumLuggageWeight;
        this.engine = engine;

        this.status = PlaneStatus.AVAILABLE;
        this.boardingType = BoardingType.NOT_STARTED;

        this.passengers = new ArrayList<>();
        this.crew = new ArrayList<>();
        this.luggage = new ArrayList<>();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public PlaneStatus getStatus() {
        return status;
    }

    public Engine getEngine() {
        return engine;
    }

    public boolean isInFlight() {
        return status == PlaneStatus.IN_FLIGHT;
    }

    public boolean isAvailableForOperation() {
        if (!engine.isValidForFlight()) {
            System.out.println(
                "\nEl motor no es válido para realizar el vuelo."
            );

            System.out.println(
                "Horas actuales: "
                + engine.getTotalFlightHours()
            );

            System.out.println(
                "Horas máximas: "
                + engine.getMaxFlightHours()
            );

            return false;
        }

        System.out.println("\nEl avión es válido para el vuelo.");

        System.out.println(
            "Horas restantes del motor: "
            + engine.getRemainingFlightHours()
        );

        return true;
    }

    public void startCrewBoarding() {
        if (!isAvailableForOperation()) {
            return;
        }

        status = PlaneStatus.BOARDING;
        boardingType = BoardingType.CREW;

        System.out.println(
            "Inició el abordaje de la tripulación."
        );
    }

    public boolean startPassengersBoarding() {
        if (status != PlaneStatus.BOARDING) {
            System.out.println(
                "El avión no se encuentra en abordaje."
            );

            return false;
        }

        if (!hasPilot()) {
            System.out.println(
                "No hay un piloto a bordo."
            );

            return false;
        }

        if (!hasCopilot()) {
            System.out.println(
                "No hay un copiloto a bordo."
            );

            return false;
        }

        boardingType = BoardingType.PASSENGERS;

        System.out.println(
            "Inició el abordaje de pasajeros."
        );

        return true;
    }

    public boolean boardPlane(Person person) {
        if (status != PlaneStatus.BOARDING) {
            System.out.println(
                person.getName()
                + " no puede abordar."
            );

            return false;
        }

        if (isPersonAlreadyOnBoard(person)) {
            System.out.println(
                person.getName()
                + " ya se encuentra en el avión."
            );

            return false;
        }

        if (person.isCrewMember()) {
            return boardCrewMember(person);
        }

        return boardPassenger(person);
    }

    private boolean boardCrewMember(Person person) {
        if (boardingType != BoardingType.CREW) {
            System.out.println(
                "El abordaje de tripulación ya terminó."
            );

            return false;
        }

        if (
            person.getRole() == Person.PersonRole.PILOT
            && hasPilot()
        ) {
            System.out.println(
                "El avión ya tiene un piloto."
            );

            return false;
        }

        if (
            person.getRole() == Person.PersonRole.COPILOT
            && hasCopilot()
        ) {
            System.out.println(
                "El avión ya tiene un copiloto."
            );

            return false;
        }

        crew.add(person);
        registerLuggage(person);

        System.out.println(
            person.getName()
            + " abordó como "
            + person.getRole()
            + "."
        );

        return true;
    }

    private boolean boardPassenger(Person person) {
        if (boardingType != BoardingType.PASSENGERS) {
            System.out.println(
                "El abordaje de pasajeros no ha iniciado."
            );

            return false;
        }

        if (passengers.size() >= passengerCapacity) {
            System.out.println(
                "El avión alcanzó su capacidad máxima."
            );

            return false;
        }

        passengers.add(person);
        registerLuggage(person);

        System.out.println(
            person.getName()
            + " abordó como pasajero."
        );

        return true;
    }

    private void registerLuggage(Person person) {
        Luggage personLuggage = person.getLuggage();

        if (personLuggage == null) {
            return;
        }

        personLuggage.checkIn();
        luggage.add(personLuggage);

        System.out.println(
            "Equipaje "
            + personLuggage.getCode()
            + " registrado: "
            + personLuggage.getWeight()
            + " kg."
        );
    }

    private boolean isPersonAlreadyOnBoard(Person person) {
        for (Person crewMember : crew) {
            if (
                crewMember.getId().equals(person.getId())
            ) {
                return true;
            }
        }

        for (Person passenger : passengers) {
            if (
                passenger.getId().equals(person.getId())
            ) {
                return true;
            }
        }

        return false;
    }

    private boolean hasPilot() {
        for (Person person : crew) {
            if (
                person.getRole()
                == Person.PersonRole.PILOT
            ) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCopilot() {
        for (Person person : crew) {
            if (
                person.getRole()
                == Person.PersonRole.COPILOT
            ) {
                return true;
            }
        }

        return false;
    }

    public double calculateTotalLuggageWeight() {
        double totalWeight = 0;

        for (Luggage currentLuggage : luggage) {
            totalWeight += currentLuggage.getWeight();
        }

        return totalWeight;
    }

    public boolean isLoadValid() {
        double totalWeight = calculateTotalLuggageWeight();

        System.out.println(
            "Peso registrado: "
            + totalWeight
            + " kg."
        );

        System.out.println(
            "Peso máximo: "
            + maximumLuggageWeight
            + " kg."
        );

        if (totalWeight > maximumLuggageWeight) {
            System.out.println(
                "La carga supera el peso máximo."
            );

            return false;
        }

        System.out.println(
            "La carga del avión es válida."
        );

        return true;
    }

    public boolean isReadyToFly() {
        boolean valid = true;

        showValidationSystemInformation();

        System.out.println("\nEjecutando verificaciones:");

        if (!engine.isValidForFlight()) {
            System.out.println(
                "Motor: NO APROBADO."
            );

            valid = false;
        } else {
            System.out.println(
                "Motor: APROBADO."
            );
        }

        if (!hasPilot()) {
            System.out.println(
                "Piloto a bordo: NO APROBADO."
            );

            valid = false;
        } else {
            System.out.println(
                "Piloto a bordo: APROBADO."
            );
        }

        if (!hasCopilot()) {
            System.out.println(
                "Copiloto a bordo: NO APROBADO."
            );

            valid = false;
        } else {
            System.out.println(
                "Copiloto a bordo: APROBADO."
            );
        }

        if (passengers.size() > passengerCapacity) {
            System.out.println(
                "Capacidad de pasajeros: NO APROBADA."
            );

            valid = false;
        } else {
            System.out.println(
                "Capacidad de pasajeros: APROBADA."
            );
        }

        if (!isLoadValid()) {
            System.out.println(
                "Carga de equipaje: NO APROBADA."
            );

            valid = false;
        } else {
            System.out.println(
                "Carga de equipaje: APROBADA."
            );
        }

        if (valid) {
            status = PlaneStatus.READY_TO_FLY;
            boardingType = BoardingType.FINISHED;

            System.out.println(
                "\nTodas las verificaciones fueron aprobadas."
            );

            System.out.println(
                "El avión está listo para volar."
            );
        } else {
            System.out.println(
                "\nEl avión no superó todas las verificaciones."
            );
        }

        return valid;
}

    public void startFlight() {
        if (status != PlaneStatus.READY_TO_FLY) {
            System.out.println(
                "El avión todavía no está listo para volar."
            );

            return;
        }

        engine.start();

        if (!engine.isRunning()) {
            return;
        }

        status = PlaneStatus.IN_FLIGHT;

        System.out.println(
            "El avión ha despegado."
        );
    }

    public void land(int flightHours) {
        if (status != PlaneStatus.IN_FLIGHT) {
            System.out.println(
                "El avión no se encuentra en vuelo."
            );

            return;
        }

        status = PlaneStatus.LANDING;

        System.out.println(
            "El avión está aterrizando."
        );

        engine.addFlightHours(flightHours);

        status = PlaneStatus.LANDED;
        engine.stop();

        System.out.println(
            "El avión aterrizó correctamente."
        );

        System.out.println(
            "Horas actuales del motor: "
            + engine.getTotalFlightHours()
        );
    }

    public void showInformation() {
        System.out.println(
            "Avión: "
            + manufacturer
            + " "
            + model
        );

        System.out.println(
            "Matrícula: "
            + registrationNumber
        );

        System.out.println(
            "Aerolínea: "
            + airline
        );

        System.out.println(
            "Capacidad: "
            + passengerCapacity
            + " pasajeros"
        );

        System.out.println(
            "Motor: "
            + engine.getModel()
        );

        System.out.println(
            "Horas máximas del motor: "
            + engine.getMaxFlightHours()
        );

        System.out.println(
            "Horas actuales del motor: "
            + engine.getTotalFlightHours()
        );
    }

    public void showFlightInformation() {
        System.out.println(
            "Estado: "
            + status
        );

        System.out.println(
            "Tripulantes a bordo: "
            + crew.size()
        );

        System.out.println(
            "Pasajeros a bordo: "
            + passengers.size()
            + "/"
            + passengerCapacity
        );

        System.out.println(
            "Maletas registradas: "
            + luggage.size()
        );

        System.out.println(
            "Peso total del equipaje: "
            + calculateTotalLuggageWeight()
            + " kg."
        );
    }

    private long calculatePower(int base, int exponent){
        if (exponent == 0) {
            return 1;
        } 

        return base * calculatePower(
            base,
            exponent - 1
        );
    }

    private void showValidationSystemInformation() {
        int possibleResultsPerCheck = 2;

        long possibleCombinations = calculatePower(
            possibleResultsPerCheck,
            NUMBER_OF_FLIGHT_CHECKS
        );

        System.out.println("\nSistema de validación del vuelo:");

        System.out.println(
            "Cantidad de verificaciones: "
            + NUMBER_OF_FLIGHT_CHECKS
        );

        System.out.println(
            "Estados posibles por verificación: "
            + possibleResultsPerCheck
        );

        System.out.println(
            "Combinaciones posibles de resultados: "
            + possibleResultsPerCheck
            + "^"
            + NUMBER_OF_FLIGHT_CHECKS
            + " = "
            + possibleCombinations
        );
    }
}