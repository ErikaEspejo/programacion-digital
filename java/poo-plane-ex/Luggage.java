public class Luggage {

    private String code;
    private double weight;
    private boolean checked;

    public Luggage(
        String code,
        double weight
    ) {
        this.code = code;
        this.weight = weight;
        this.checked = false;
    }

    public String getCode() {
        return code;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isChecked() {
        return checked;
    }

    public void checkIn() {
        checked = true;
    }
}