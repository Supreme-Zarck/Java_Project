package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import buisness.Passenger;
import buisness.Vol;

public class PassengerDAO {
    MaConnexion connexion;
    Statement stmt;
    Scanner sc = new Scanner(System.in);
    private int id;
    
    public PassengerDAO(MaConnexion connexion,int id) {
        this.connexion = connexion;
        stmt = connexion.getStmt();
        this.id=id;
    }


    public void consulterSIVolDisponibles(String destination, String origine) throws SQLException {
        ResultSet resultat_vol = stmt.executeQuery("SELECT * FROM vol");

        String lowerDestination = destination.toLowerCase();
        String lowerOrigine = origine.toLowerCase();
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        System.out.println("| La liste des vols disponibles (matching destination and origin): ");
        boolean flightFound = false;

        while (resultat_vol.next()) {
            Vol vol = new Vol(
                    resultat_vol.getString("destination"),
                    resultat_vol.getString("origine"),
                    resultat_vol.getString("depart"),
                    resultat_vol.getString("arrive"),
                    resultat_vol.getDouble("prix"));

            String storedDestination = vol.getDestination().toLowerCase();
            String storedOrigine = vol.getOrigine().toLowerCase();

            if (storedDestination.equals(lowerDestination) && storedOrigine.equals(lowerOrigine)) {
                System.out.println(vol);
                flightFound = true;
                choisirVol(id);
                break;
            }
        }

        if (!flightFound) {
            System.out.println("| No flight exists for the given destination and origin.");
        }

        sc.nextLine();
    }


    public void choisirVol(int passengerId) throws SQLException {
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
    	System.out.println("| choisir l'id du vol : ");
        int id_vol = sc.nextInt();
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        ResultSet existingEntry = stmt.executeQuery("SELECT * FROM vol_passenger WHERE vol_id='" + id_vol + "' AND passenger_id='" + passengerId + "'");
        if (existingEntry.next()) {
            System.out.println("| You have already booked this flight.");
        } else {
            stmt.executeUpdate("INSERT INTO vol_passenger ( passenger_id, vol_id) VALUES ('" +passengerId+ "','"+id_vol+"')");
            effectuerPaiement(id,id_vol);
            System.out.println("| Booking successful!");
        }
        sc.nextLine();
    }
	public void consulterInformations(int id) throws SQLException {
	    System.out.println("** Vos Informations **");
	    ResultSet resultat_passenger = stmt.executeQuery("SELECT * FROM passenger WHERE ID='" + id + "'");
	    if (resultat_passenger.next()) {
	    	Passenger passenger = new Passenger(resultat_passenger.getString("username"),
	                                      resultat_passenger.getString("password"),
	                                      resultat_passenger.getString("nom"),
	                                      resultat_passenger.getString("prenom"),
	                                      resultat_passenger.getString("num_passport"));
	                                     
	        System.out.println(passenger+" numero passport : "+resultat_passenger.getString("num_passport"));
	        System.out.print("| Voulez-vous changer les informations ? (o pour oui / n pour non ) :");
	        String reponse = sc.nextLine();
	        if ("o".equals(reponse)) {
	            System.out.print("| Entrer le nouveau username : ");
	            String username = sc.nextLine();
	            stmt.executeUpdate("UPDATE passenger SET username='" + username + "' WHERE ID='" + id + "'");

	            System.out.print("| Entrer le nouveau password : ");
	            String password = sc.nextLine();
	            stmt.executeUpdate("UPDATE passenger SET password='" + password + "' WHERE ID='" + id + "'");

	            System.out.print("| Entrer le nouveau passport : ");
	            String num_passport = sc.nextLine();
	            stmt.executeUpdate("UPDATE passenger SET num_passport='" + num_passport + "' WHERE ID='" + id + "'");
	        }
	    }
	}
    public void effectuerPaiement(int id, int vol_id) throws SQLException {
        ResultSet resultat_vol = stmt.executeQuery("SELECT * FROM vol WHERE id='" + vol_id + "'");

        if (resultat_vol.next()) {
            Vol vol = new Vol(
                    resultat_vol.getString("destination"),
                    resultat_vol.getString("origine"),
                    resultat_vol.getString("depart"),
                    resultat_vol.getString("arrive"),
                    resultat_vol.getDouble("prix"));
            sc.nextLine();
            System.out.println("| affirmer le mot de passe : ");
            String password = sc.nextLine();
            ResultSet resultat_passenger = stmt.executeQuery("SELECT * FROM passenger WHERE ID='" + id + "'");
            if (resultat_passenger.next() && password.equals(resultat_passenger.getString("password"))) {

                System.out.println("| Choisir Classe ( 1 : business , 2 : economie ) : ");
                int reponse_class = sc.nextInt();
                String classe_vol = null;

                switch (reponse_class) {
                    case 1:
                        classe_vol = "business";
                        vol.setPrix(vol.getPrix() + (vol.getPrix() * 0.5));
                        stmt.executeUpdate("UPDATE `vol_passenger` SET `class`='"+classe_vol+"' WHERE passenger_id='"+id+"'");
                        afficherTicket();
                        break;
                    case 2:
                        classe_vol = "economie";
                        stmt.executeUpdate("UPDATE `vol_passenger` SET `class`='"+classe_vol+"' WHERE passenger_id='"+id+"'");
                        afficherTicket();
                        break;
                    default:
                        break;
                }
            }
        }
    }
    private void afficherTicket() {
        System.out.println("| Paiement bien effectue '-' ");
	}
}
