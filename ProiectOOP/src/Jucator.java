import java.util.*;

public class Jucator {
    private String nume;
    private double bani;
    private int rebirth;
    private List<Productie> productii;
    private List<Upgrade> upgradeuri;

    public Jucator(String nume) {
        this.nume = nume;
        this.bani = 1000;
        this.rebirth = 1;
        this.productii = new ArrayList<>();
        this.upgradeuri = new ArrayList<>();
    }

    public void cumparaProductie(Productie p) {
        this.bani= this.bani - (p.getPret());
        productii.add(p);
    }

    public void genereazaVenitTotal() {
        for (Productie p : productii) {
            bani += p.genereazaVenit();
        }
    }

    public void reset(){
        this.rebirth++;
        this.bani = 1000 * rebirth;
        this.productii = new ArrayList<>();
        this.upgradeuri = new ArrayList<>();
    }

    public void afiseazaBani() {
        System.out.printf("Bani actuali: %.2f RON%n", bani);
    }
    public List<Productie> getProductii() {
        return productii;
    }

    public double getBani() {
        return bani;
    }

    public void scadeBani(double suma) {
        bani -= suma;
    }

    public int getRebirth(){
        return rebirth;
    }
}
