package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AeroportDAO {

	MaConnexion connexion;
	Statement stmt;
	Scanner sc = new Scanner(System.in);
	private String username;
	private String password;
	private int id;
	public AeroportDAO(MaConnexion connexion) throws SQLException {
		this.connexion = connexion;
		stmt = connexion.getStmt();
		demarrage();
	}
	
	private void demarrage() throws SQLException {
		int reponse;
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
		System.out.println("+                           Bienvenue dans l'application de gestion d'aeroport Arcane                            +");
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");

		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
		System.out.println("| Mode d'authentification ( 1 : Admin , 2 : Employe , 3 : Passenger )");
		System.out.print("| Si vous etes un nouveau client et vous chercher a s'inscrire tapez 4 : ");
		reponse = sc.nextInt();
		sc.nextLine();
		if (reponse == 4) {
			signUP();
			demarrage();
		} else {
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
			System.out.print("| username : ");
			username = sc.nextLine();
			System.out.print("| password : ");
			password = sc.nextLine();
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
			switch (reponse) {
			case 1:
				login1();
				break;
			case 2:
				login2();
				break;
			case 3:
				login3();
				break;
			default:
				break;
			}
		}
		
	}


	private void login1() throws SQLException {
	    ResultSet resultat_admin = stmt.executeQuery("SELECT * FROM admin WHERE username='" + username + "' AND password='" + password + "'");
	    if (resultat_admin.next() && username.equals(resultat_admin.getString("username")) && password.equals(resultat_admin.getString("password"))) {
            id = resultat_admin.getInt("id");
	        menuAdmin(resultat_admin.getString("nom"), resultat_admin.getString("prenom"));
	    } else {
	    	System.out.println("\n!!! Votre informations est fause !!!\n");
	    	demarrage();
	    }
	}
	
	private void login2() throws SQLException {
	    ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe WHERE username='" + username + "' AND password='" + password + "'");
		if (resultat_employe.next() && username.equals(resultat_employe.getString("username")) && password.equals(resultat_employe.getString("password"))) {
            id = resultat_employe.getInt("id");
	        menuEmploye(resultat_employe.getString("nom"), resultat_employe.getString("prenom"));
	    } else {
	    	System.out.println("\n!!! Votre informations est fause !!!\n");
	    	demarrage();
	    }
	}
	

	private void login3() throws SQLException {
	    ResultSet resultat_passenger = stmt.executeQuery("SELECT * FROM passenger WHERE username='" + username + "' AND password='" + password + "'");
		if (resultat_passenger.next() && username.equals(resultat_passenger.getString("username")) && password.equals(resultat_passenger.getString("password"))) {
            id = resultat_passenger.getInt("id");
	        menupassenger(resultat_passenger.getString("nom"), resultat_passenger.getString("prenom"));
	    } else {
	    	System.out.println("\n!!! Votre informations est fause !!!\n");
	    	demarrage();
	    }
	}
	
	private void signUP() throws SQLException {

			System.out.print("| Entrer username : ");
			String passenger_username = sc.nextLine();
			System.out.print("| Entrer password : ");
			String passenger_password = sc.nextLine();
			System.out.print("| Entrer nom : ");
			String passenger_nom = sc.nextLine();
			System.out.print("| Entrer prenom : ");
			String passenger_prenom = sc.nextLine();
			System.out.print("| Entrer numero de votre pasport : ");
			String passenger_passport = sc.nextLine();

			stmt.executeUpdate("INSERT INTO passenger (username, password, nom, prenom,num_passport) VALUES ('" + passenger_username + "','" + passenger_password + "','" + passenger_nom + "','" + passenger_prenom + "','" + passenger_passport +"')");
			System.out.println("| + => Vous avez bien ajoutez " + passenger_nom+" "+passenger_prenom);
			System.out.print("| Voulez vous avez bien etait inscris ");

			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
	}

	
	private void menupassenger(String nom, String prenom) throws SQLException {
		PassengerDAO passengerDAO = new PassengerDAO(connexion, id);
		System.out.println("|Bonjours passenger |-----> " +nom+ " " + prenom);
		char reponse='o';
		while(reponse=='o'){
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
			System.out.println("|Chosir l'operation a effectuer\n"
					+ "|-----> Consulter les informations [1]\n"
					+ "|-----> Consulter les vols et effectue un paiment [2]\n"
					+ "|-----> Log Out [ another number ]");
			System.out.println("+----------------------------------------------------------------------------------------------------------------+\n");
			int reponse_champ = sc.nextInt();
			sc.nextLine();

			switch (reponse_champ) {
				case 1:
					passengerDAO.consulterInformations(id);
					break;
				case 2:
					System.out.println("Entrer destination : ");
					String destination = sc.nextLine();
					System.out.println("Entrer l'origine : ");
					String origine = sc.nextLine();
					passengerDAO.consulterSIVolDisponibles(destination,origine);;
					break;
				default:
					demarrage();
			}
			System.out.println("Voulez vous effectuer une autre operation ? ( 'o' pour oui , 'n'importe caractere' pour non ) : ");
			reponse = sc.next().charAt(0);

			sc.nextLine();
		}
	}

	private void menuAdmin(String nom, String prenom) throws SQLException {
		AdminDAO adminDAO = new AdminDAO(connexion); 
		System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		System.out.println("|Bonjours Admin |----->  " +nom+ " " + prenom);
		char reponse='o';
		while(reponse=='o'){
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
		System.out.print("|Chosir l'operation a effectuer \n"
				+ "|-----> Ajouter [1 : Employe, 2 : Vol, 3 : Avion]\n"
				+ "|-----> Modifier [4 : Employe, 5 : Vol, 6 : Avion]\n"
				+ "|-----> Supprimer [7 : Employe, 8 : Vol, 9 : Avion]\n"
				+ "|-----> Afficher [10 : Employe, 11 : Vol, 12 : Avion]\n"
				+ "|-----> Generer un rapport : 13\n"
				+ "|-----> Consulter Vos informations : 14\n"
				+ "|-----> Ajouter un nouveau Admin : 15\n"
				+ "|-----> Log Out [ another number ]\n"
				+ "|-----> Votre choix : ");
		int reponse_champ = sc.nextInt();
		System.out.println("+----------------------------------------------------------------------------------------------------------------+\n");
		sc.nextLine();

		switch (reponse_champ) {
		case 1:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.ajouterEmploye();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 2:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.ajouterVol();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 3:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.ajouterAvion();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 4:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.modfierEmployee();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 5:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.modifierVol();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 6:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.modifierAvion();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 7:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.supprimerEmploye();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 8:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.supprimerVol();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 9:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.supprimerAvion();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 10:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.afficherEmploye();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 11:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.afficherVol();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 12:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
            adminDAO.afficherAvion();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
            break;
        case 13:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        	adminDAO.genererRapportAeroport();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
        	break;
        case 14:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        	adminDAO.consulterInformations(id);
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
        	break;
        case 15:
			System.out.println("+----------------------------------------------------------------------------------------------------------------+");
        	adminDAO.ajouterAdmin();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
        	break;
        default:
        	demarrage();
        	}
		
		
		System.out.print("| Voulez vous effectuer une autre operation ? ( 'o' pour oui , 'n'importe caractere' pour non ) : ");
		reponse = sc.next().charAt(0);
		sc.nextLine();
		}
	}

	private void menuEmploye(String nom, String prenom) throws SQLException {
		EmployeDAO employeDAO = new EmployeDAO(connexion);
		System.out.println("| Bonjours employe |-----> " +nom+ " " + prenom);
		char reponse='o';
		while(reponse=='o'){
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
			System.out.println("Chosir l'operation a effectuer\n"
					+ "|-----> Consulter les informations [1]\n"
					+ "|-----> Consulter les vols [2]\n"
					+ "|-----> Log Out [ another number ]");
			System.out.println("+----------------------------------------------------------------------------------------------------------------+\n");
			int reponse_champ = sc.nextInt();
			sc.nextLine();
			switch (reponse_champ) {
				case 1:
					System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
					employeDAO.consulterInformations(id);
					System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
					break;
				case 2:
					System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
					employeDAO.consulterAvionAffecte(id);
					System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
					break;
				default:
		        	demarrage();
			}
			System.out.println("| Voulez vous effectuer une autre operation ? ( 'o' pour oui , 'n'importe caractere' pour non ) : ");
			reponse = sc.next().charAt(0);
			sc.nextLine();
		}
	}
}