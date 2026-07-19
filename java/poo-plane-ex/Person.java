public class Person {

    private String id;
    private String name;
    private String birthDate;
    private PersonRole role;
    private Luggage luggage;

    public enum PersonRole {
        PASSENGER,
        COPILOT,
        PILOT,
        FLIGHT_ATTENDANT
    }

    public Person(
        String id,
        String name,
        String birthDate,
        PersonRole role
    ) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public PersonRole getRole() {
        return role;
    }

    public Luggage getLuggage() {
        return luggage;
    }

    public void setLuggage(Luggage luggage) {
        this.luggage = luggage;
    }

    public boolean isPassenger() {
        return role == PersonRole.PASSENGER;
    }

    public boolean isCrewMember() {
        return role == PersonRole.PILOT
            || role == PersonRole.COPILOT
            || role == PersonRole.FLIGHT_ATTENDANT;
    }
}