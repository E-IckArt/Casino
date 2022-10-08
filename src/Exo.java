//Exercice utilisé comme base : Défi du cours JAVA - Les instructions conditionnelles (Module : Découvrir Java)
// ??? Le Defi du cours - Les méthodes est similaire, si ce n'est identique.

import java.util.Scanner;
import java.util.Random;

public class Exo {

    public static int budget = 1000;    /*La variable déclarée ici à une portée sur tout le code.
    Il n'est plus nécessaire de la déclarer à nouveau.*/
    public static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue au jeu : Plus ou moins !");

        // Boucle principale du jeu
        do{

            System.out.println("Budget du joueur: " + budget);
            System.out.println("Saisissez votre mise (en chocobons) :");
            int mise= clavier.nextInt();
            System.out.println("Vous avez misé " + mise + "chocobons.");

            if(budget >= mise) {
                budget = budget - mise; // budget -= mise est une autre manière d'écrire

                System.out.println("Vous jouez pour gagner " + mise * 2 + " chocobons. Prêt?");

                // Jouer
                int nombreMystere = (new Random()).nextInt(10);

                // TODO : Supprimer la ligne suivante. Elle sert à vérifier que le programme fonctionne.
                System.out.println("nombreMystere à deviner : " + nombreMystere);


                int tentativesAutorisees = 3;
                boolean nombreDevine = false;


                while (tentativesAutorisees > 0 && !nombreDevine) {
                    System.out.println("Tapez un nombre entre 0 et 10");
/* Comment bloquer l'entrée pour que l'utilisateur ne puisse pas mettre de nombre <0 ou >10 + afficher une alerte.*/

                    int nombreJoueur = clavier.nextInt();
                    tentativesAutorisees = tentativesAutorisees -1;

                    if (nombreJoueur == nombreMystere) {
                        nombreDevine = true;
                        System.out.println("Bravo, vous avez deviné !");
                        budget = budget + (mise * 2);
                        System.out.println("Vous gagnez : " + mise * 2 + " chocobons !");
                        System.out.println("Vous avez maintenant un total de : " + budget);

                    } else if (tentativesAutorisees > 0 && tentativesAutorisees != 1) {
                        System.out.println("Dommage ! Le nombre mystère n'est pas : " + nombreJoueur);
                        System.out.println("Il vous reste : " + tentativesAutorisees + " tentatives");
                    } else if (tentativesAutorisees == 1) {
                        System.out.println("Essayez encore ! Il vous reste " + tentativesAutorisees + " tentative");
                    } else {
                        System.out.println("Oh non! Vous avez perdu ! Le nombre à deviner était: " + nombreMystere);
                    }
                }

            } else {
                System.out.println("Votre budget n'est pas suffisant !");
                System.out.println("Il vous reste : " + budget + " chocobon(s)");
            }

        } while (continuerJouer());

        clavier.close();

        System.out.println("Fin du programme");
    }

//  ? La boucle secondaire commence ici ?

    public static boolean continuerJouer() {
        if(budget > 0) {
            System.out.println("Voulez-vous continuer à jouer ? (oui/non)");
            String continuer = clavier.next();
            if(continuer.equals("oui")) { // Le == ne fonctionne pas ici, car il s'agit d'un objet (un String). Il faut utiliser ".equals". === n'existe pas en java.
                return true;
// ? Comment bloquer l'entrée pour que l'utilisateur ne puisse pas mettre autre chose que oui ou non + afficher une alerte ?
            } else {
                System.out.println("Bien compris, je vous rends votre argent : " + budget);
                System.out.println("Revenez jouer à Plus ou Moins quand vous voudrez. A bientôt !");
                return false;
            }
                // return false; => Ligne passée en commentaire temporaire pdt le live. Je ne sais plus à quoi elle sert.
        } else {
            System.out.println("Vous n'avez plus assez de chocobons pour jouer. Achetez-en à la boutique ou revenez nous voir dès demain. A très vite !");
            return false;
        }
        //return true;
        }

}
