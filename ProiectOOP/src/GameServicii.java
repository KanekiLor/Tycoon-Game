import java.util.*;

public class GameServicii {
    private final Jucator player;
    private final List<Productie> productieDisponibila;
    private final List<Upgrade> upgradeuriDisponibile;

    public GameServicii(Jucator player) {
        this.player = player;
        this.productieDisponibila = new ArrayList<>();
        this.upgradeuriDisponibile = new ArrayList<>();
        initializare();
    }

    private void initializare() {
        productieDisponibila.add(new Productie("Gratar Automat", 5, new Produs("Burger", 10), 1000));
        productieDisponibila.add(new Productie("Cuptor Turbo", 8, new Produs("Pizza", 20), 3000));
        productieDisponibila.add(new Productie("Espressor Cafe", 6, new Produs("Cafea", 15), 2000));
        productieDisponibila.add(new Productie("Aparat Milkshake", 7, new Produs("Milkshake", 18), 2500));
        productieDisponibila.add(new Productie("Stand Hotdog", 9, new Produs("Hotdog", 25), 3500));
        productieDisponibila.add(new Productie("Fabrica de Paste", 10, new Produs("Paste", 30), 5000));
        productieDisponibila.add(new Productie("Cuptor Electric Tarta", 12, new Produs("Tarta", 35), 6500));

        productieDisponibila.add(new ProductiePremium("[PREMIUM]Robot Burgerizer", 10, new Produs("RoboBurger", 50), 8000, 0.2));
        productieDisponibila.add(new ProductiePremium("[PREMIUM]Cuptor Nuclear Pizza", 15, new Produs("Pizza Radioactiva", 70), 12000, 0.3));
        productieDisponibila.add(new ProductiePremium("[PREMIUM]Fabrica de Donuts Inteligenta", 18, new Produs("SmartDonut", 90), 15000, 0.4));

        upgradeuriDisponibile.add(new Upgrade("x2 Profit", 500, 2.0));
        upgradeuriDisponibile.add(new Upgrade("x3 Profit", 1000, 3.0));
        upgradeuriDisponibile.add(new Upgrade("x5 Profit", 3000, 5.0));
        upgradeuriDisponibile.add(new Upgrade("x10 Turbo Profit", 7000, 10.0));
        upgradeuriDisponibile.add(new Upgrade("x15 Ultra Boost", 12000, 15.0));

        productieDisponibila.sort((p1, p2) -> Double.compare(p1.getPret(), p2.getPret()));
    }

    public void afiseazaBani() {
        player.afiseazaBani();
    }

    public void afiseazaProductiiActive() {
        System.out.println("Productiile tale:");
        for (Productie p : player.getProductii()) {
            System.out.println("- " + p.getNume() + " (Nivel " + p.getNivel() + ", Venit/sec: " + p.genereazaVenit() + ")");
        }
    }

    public void genereazaVenit() {
        player.genereazaVenitTotal();
        System.out.println("Venit generat!");
    }

    public void afiseazaProductiiDisponibile() {
        System.out.println("Productii disponibile:");
        for (int i = 0; i < productieDisponibila.size(); i++) {
            Productie p = productieDisponibila.get(i);
            System.out.println((i + 1) + ". " + p.getNume() + ". Pret: " + p.getPret() + ". Venit/sec:" + p.genereazaVenit());
        }
    }

    public void cumparaProductie(int index) {
        if (index >= 0 && index < productieDisponibila.size()) {
            Productie aleasa = productieDisponibila.get(index);
            if (aleasa.getPret() <= player.getBani()) {
                player.cumparaProductie(aleasa);
                System.out.println("Ai cumparat: " + aleasa.getNume());
            } else {
                System.out.println("Nu ai fonduri suficiente!");
            }
        } else {
            System.out.println("Productie invalida.");
        }
    }

    public void afiseazaUpgradeuriDisponibile() {
        System.out.println("Upgrade-uri disponibile:");
        for (int i = 0; i < upgradeuriDisponibile.size(); i++) {
            Upgrade u = upgradeuriDisponibile.get(i);
            System.out.println((i + 1) + ". " + u.getNume() + " (Cost: " + u.getCost() + ")");
        }
    }

    public void aplicaUpgrade(int upIndex, int prodIndex) {
        if (upIndex >= 0 && upIndex < upgradeuriDisponibile.size()
                && prodIndex >= 0 && prodIndex < player.getProductii().size()) {

            Upgrade u = upgradeuriDisponibile.get(upIndex);
            Productie p = player.getProductii().get(prodIndex);

            if (player.getBani() >= u.getCost()) {
                u.aplica(p);
                player.scadeBani(u.getCost());
                System.out.println("Ai aplicat upgrade-ul " + u.getNume() + " pe " + p.getNume());
            } else {
                System.out.println("Nu ai bani suficienti.");
            }
        } else {
            System.out.println("Index invalid.");
        }
    }

    public void rebirth() {
        if (player.getBani() >= 10000) {
            player.reset();
        }
    }

    public void afiseazaRebirths() {
        System.out.print("Total rebirths " + player.getRebirth() + ".");
    }

    public boolean areProductii() {
        return !player.getProductii().isEmpty();
    }

    public int getNrProductii() {
        return player.getProductii().size();
    }

    public String getNumeProductie(int index) {
        return player.getProductii().get(index).getNume();
    }
}
