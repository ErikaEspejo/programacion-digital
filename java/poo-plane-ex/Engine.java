public class Engine {

    private String serialNumber;
    private String model;
    private int maxFlightHours;
    private int totalFlightHours;
    private boolean running;

    public Engine(
        String serialNumber,
        String model,
        int maxFlightHours,
        int totalFlightHours
    ) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.maxFlightHours = maxFlightHours;
        this.totalFlightHours = totalFlightHours;
        this.running = false;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public int getMaxFlightHours() {
        return maxFlightHours;
    }

    public int getTotalFlightHours() {
        return totalFlightHours;
    }

    public boolean isRunning() {
        return running;
    }

    public int getRemainingFlightHours() {
        return maxFlightHours - totalFlightHours;
    }

    public boolean isValidForFlight() {
        return totalFlightHours < maxFlightHours;
    }

    public void start() {
        if (!isValidForFlight()) {
            System.out.println(
                "El motor superó el máximo de horas permitidas."
            );

            return;
        }

        if (running) {
            System.out.println(
                "El motor ya se encuentra encendido."
            );

            return;
        }

        running = true;

        System.out.println("Motor encendido.");
    }

    public void stop() {
        if (!running) {
            System.out.println(
                "El motor ya se encuentra apagado."
            );

            return;
        }

        running = false;

        System.out.println("Motor apagado.");
    }

    public void addFlightHours(int flightHours) {
        if (flightHours <= 0) {
            System.out.println(
                "Las horas deben ser mayores que cero."
            );

            return;
        }

        totalFlightHours += flightHours;
    }
}