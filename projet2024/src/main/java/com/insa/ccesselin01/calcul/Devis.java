package com.insa.ccesselin01.calcul;

/**
 *
 * @author ccesselin01
 */
import java.util.HashMap;
import java.util.Map;

public class Devis {
    private HashMap<Revetement, Double> prixRevetements; // Revêtement -> Coût en euros

    public Devis() {
        prixRevetements = new HashMap<>();
    }

    public void ajouterRevetement(Revetement revetement, double surface) {
        if (prixRevetements.containsKey(revetement)) {
            double coûtActuel = prixRevetements.get(revetement);
            double coûtRevêtement = coûtActuel + (revetement.getPrixunitaire()* surface);
            prixRevetements.put(revetement, coûtRevêtement);
        } else {
            double coutRevetement = revetement.getPrixunitaire()* surface;
            prixRevetements.put(revetement, coutRevetement);
        }
    }

    public HashMap<Revetement, Double> getPrixRevetements() {
        return prixRevetements;
    }

    public double getTotal() {
        double total = 0.0;
        for (double coût : prixRevetements.values()) {
            total += coût;
        }
        return total;
    }
}
