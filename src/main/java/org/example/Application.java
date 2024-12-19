package org.example;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierProduitImpl metier = new MetierProduitImpl();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter ce programme");
            System.out.print("Choisissez une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    if (produits.isEmpty()) {
                        System.out.println("Aucun produit disponible.");
                    } else {
                        for (Produit produit : produits) {
                            System.out.println(produit);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'id du produit: ");
                    long idRecherche = scanner.nextLong();
                    Produit produit = metier.findById(idRecherche);
                    if (produit != null) {
                        System.out.println(produit);
                    } else {
                        System.out.println("Produit introuvable.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'id: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez le nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque: ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le stock: ");
                    int stock = scanner.nextInt();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;
                case 4:
                    System.out.print("Entrez l'id du produit à supprimer: ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé avec succès.");
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
