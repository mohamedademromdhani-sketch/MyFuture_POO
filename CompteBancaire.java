
public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private static int nombreComptes = 0;

    public CompteBancaire(String numeroCompte, double soldeInitial,  Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.titulaire = titulaire;
        nombreComptes++;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    public static int getNombreComptes() {
        return nombreComptes;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant
                    + " TND effectué sur le compte " + numeroCompte + ".");
        } else {
            System.out.println("Erreur : montant invalide.");
        }
    }

    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Erreur : montant invalide.");
        } else if (montant > solde) {
            System.out.println("Échec : Solde insuffisant sur le compte "
                    + numeroCompte + " (Solde actuel : "
                    + solde + " TND).");
        } else {
            solde -= montant;
            System.out.println("Retrait de " + montant
                    + " TND effectué sur le compte " + numeroCompte + ".");
        }
    }

    public void virement(CompteBancaire destination, double montant) {
        System.out.println("\nTentative de virement de " + montant
                + " TND vers le compte " + destination.getNumeroCompte() + "...");

        if (destination == this) {
            System.out.println("Erreur : impossible de faire un virement "
                    + "vers le même compte.");
        } else if (montant <= 0) {
            System.out.println("Erreur : montant invalide.");
        } else if (montant > solde) {
            System.out.println("Échec : Solde insuffisant.");
        } else {
            this.retirer(montant);
            destination.deposer(montant);
            System.out.println("Virement réussi !");
        }
    }

    public void afficherDetails() {
        System.out.println("Compte N° : " + numeroCompte);
        System.out.print("Titulaire : ");
        titulaire.afficherClient();
        System.out.println("Solde Actuel : " + solde + " TND");
    }
}
