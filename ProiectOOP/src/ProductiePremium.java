public class ProductiePremium extends Productie {
    private double bonusProfit;

    public ProductiePremium(String nume, int nivel, Produs produs, int pret, double bonusProfit) {
        super(nume, nivel, produs, pret);
        this.bonusProfit = bonusProfit;
    }

    @Override
    public double genereazaVenit() {
        double venitDeBaza = super.genereazaVenit();
        return venitDeBaza + (venitDeBaza * bonusProfit);
    }


}
