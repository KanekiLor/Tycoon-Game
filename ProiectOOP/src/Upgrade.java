public class Upgrade {
    private String nume;
    private double cost;
    private double multiplicator;

    public Upgrade(String nume, double cost, double multiplicator) {
        this.nume = nume;
        this.cost = cost;
        this.multiplicator = multiplicator;
    }

    public void aplica(Productie productie) {
        productie.upgrade();
    }

    public String getNume() {
        return nume;
    }

    public double getCost() {
        return cost;
    }
}
