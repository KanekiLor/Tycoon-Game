public class Productie {
    private String nume;
    private int nivel;
    private double venitPeSecunda;
    private Produs produs;
    private double pret;

    public Productie(String nume, double venitPeSecunda, Produs produs, double pret) {
        this.nume = nume;
        this.venitPeSecunda = venitPeSecunda;
        this.produs = produs;
        this.pret = pret;
        this.nivel = 1;
    }

    public void upgrade() {
        nivel++;
        venitPeSecunda *= 1.5;
    }

    public double genereazaVenit() {
        return venitPeSecunda;
    }

    public double getPret() {
        return pret;
    }

    public String getNume() {
        return nume;
    }

    public int getNivel() {
        return nivel;
    }
}
