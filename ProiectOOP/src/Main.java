import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameServicii game = new GameServicii(new Jucator("RaresTycoon"));

        int optiune = -1;
        while (optiune != 0) {
            System.out.println("\n=== MENIU TYCOON ===");
            System.out.println("1. Afiseaza bani");
            System.out.println("2. Afiseaza productii active");
            System.out.println("3. Genereaza venit");
            System.out.println("4. Cumpara productie");
            System.out.println("5. Cumpara upgradeuri");
            System.out.println("6. Rebirth(Minim 10k$)");
            System.out.println("7. Afisare Rebirths");
            System.out.println("8. Salveaza progresul");
            System.out.println("9. Incarca salvare");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 1 -> game.afiseazaBani();
                case 2 -> game.afiseazaProductiiActive();
                case 3 -> game.genereazaVenit();
                case 4 -> {
                    game.afiseazaProductiiDisponibile();
                    System.out.print("Alege productia: ");
                    int idx = scanner.nextInt() - 1;
                    game.cumparaProductie(idx);
                }
                case 5 -> {
                    game.afiseazaUpgradeuriDisponibile();
                    System.out.print("Alege upgrade-ul: ");
                    int upIdx = scanner.nextInt() - 1;

                    if (!game.areProductii()) {
                        System.out.println("Nu ai nicio productie!");
                        break;
                    }

                    System.out.println("Alege productia pentru upgrade:");
                    for (int i = 0; i < game.getNrProductii(); i++) {
                        System.out.println((i + 1) + ". " + game.getNumeProductie(i));
                    }
                    int prodIdx = scanner.nextInt() - 1;

                    game.aplicaUpgrade(upIdx, prodIdx);
                }
                case 6 -> {
                    System.out.println("Atentie! Veti pierde toti banii!");
                    System.out.print("Daca vreti sa continuati introduceti 1: ");
                    int idx = scanner.nextInt() - 1;
                    if(idx == 1) {
                        game.rebirth();
                    }
                }
                case 7 -> {
                    System.out.println("Total rebirths:");
                    game.afiseazaRebirths();
                }
                case 0 -> System.out.println("Joc inchis. Re!");
                default -> System.out.println("Optiune invalida.");
            }
        }

        scanner.close();
    }
}
