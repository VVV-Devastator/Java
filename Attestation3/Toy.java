package Attestation3;

public class Toy {
    private String id;
    private String name;
    private int quantity;
    private double frequency;

    public Toy(String id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void decrementQuantity() {
        quantity--;
    }
}
