package DAO;

import buisness.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdminDAO {
	MaConnexion connexion;
	Statement stmt;
	Scanner sc = new Scanner(System.in);
	private String[] jours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
///////////////////////////////////////////////////////////////////// Constructor
	public AdminDAO(MaConnexion connexion) {
		this.connexion = connexion;
		stmt = connexion.getStmt();
	}

	public void consulterInformations(int id) throws SQLException {
	    System.out.println("** Vos Informations **");
	    ResultSet resultat_admin = stmt.executeQuery("SELECT * FROM admin WHERE ID='" + id + "'");
	    if (resultat_admin.next()) {
	        Admin admin = new Admin(resultat_admin.getString("username"),
	                                      resultat_admin.getString("password"),
	                                      resultat_admin.getString("nom"),
	                                      resultat_admin.getString("prenom"));
	        System.out.println(admin);
	        System.out.println("| Voulez-vous changer les informations ? (o pour oui / n pour non ) :");
	        String reponse = sc.nextLine();
	        if ("o".equals(reponse)) {
	            System.out.println("| Entrer le nouveau username : ");
	            String username = sc.nextLine();
	            stmt.executeUpdate("UPDATE admin SET username='" + username + "' WHERE ID='" + id + "'");

	            System.out.println("| Entrer le nouveau password : ");
	            String password = sc.nextLine();
	            stmt.executeUpdate("UPDATE admin SET password='" + password + "' WHERE ID='" + id + "'");
	        }
	    }
	}
	
	
	public void ajouterAdmin() throws SQLException {
		char reponse = 'o';
		while (reponse == 'o') {
			System.out.print("| Entrer username : ");
			String admin_username = sc.nextLine();
			System.out.print("| Entrer password : ");
			String admin_password = sc.nextLine();
			System.out.print("| Entrer nom : ");
			String admin_nom = sc.nextLine();
			System.out.print("| Entrer prenom : ");
			String admin_prenom = sc.nextLine();

			stmt.executeUpdate("INSERT INTO admin (username, password, nom, prenom) VALUES ('" + admin_username + "','" + admin_password + "','" + admin_nom + "','" + admin_prenom +"')");
			System.out.println("| + => Vous avez bien ajoutez " + admin_nom+" "+admin_prenom);
			System.out.print("| Voulez vous ajoutez un nouveau admin (o pour oui / n pour non ) : ");
			reponse = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		}
	}
	
///////////////////////////////////////////////////////////////////// Employee
	
	public void ajouterEmploye() throws SQLException {
		char reponse = 'o';
		while (reponse == 'o') {
			System.out.print("| Entrer username : ");
			String employe_username = sc.nextLine();
			System.out.print("| Entrer password : ");
			String employe_password = sc.nextLine();
			System.out.print("| Entrer nom : ");
			String employe_nom = sc.nextLine();
			System.out.print("| Entrer prenom : ");
			String employe_prenom = sc.nextLine();
			System.out.print("| Entrer role : ");
			String employe_role = sc.nextLine();
			System.out.print("| Entrer le departement de l'employee (1 pour Ground Stuff / 2 pour Flight Stuff) : ");
			int choix = sc.nextInt();
			String employe_departement;
			System.out.print("| Entrer Salaire : ");
			double employe_salaire = sc.nextDouble();
			if (choix == 1) {
				employe_departement = "Ground Stuff";
			} else {
				employe_departement = "Flight Stuff";
			}
			stmt.executeUpdate("INSERT INTO employe (username, password, nom, prenom, role, departement, salaire) VALUES ('" + employe_username + "','" + employe_password + "','" + employe_nom + "','" + employe_prenom + "','" + employe_role + "','" + employe_departement + "','" + employe_salaire + "')");
			System.out.println("| + => Vous avez bien ajoutez " + employe_nom+" "+employe_prenom);
			System.out.print("| Voulez vous ajoutez un nouveau employe (o pour oui / n pour non ) : ");
			reponse = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		}
		affecterEmploiDuTempsDepart2();
	}
	
	public void modfierEmployee() throws SQLException {
		char reponse='o';
		while(reponse=='o'){
			System.out.print("| Choisir l'id de l'employee : ");
			int employe_id = sc.nextInt();
			sc.nextLine();
			System.out.print("| Chosir le champ a modifier ( 1 : Username , 2 : Password , 3 : Nom , 4 : Prenom , 5 : Role , 6 : Salaire ) : ");
			int reponse_champ = sc.nextInt();
			sc.nextLine();
			switch (reponse_champ) {
				case 1:
					System.out.print("| Entrer le nouveau username : ");
					String employeUsername = sc.nextLine();
					stmt.executeUpdate("UPDATE employe SET username='"+employeUsername+"' WHERE ID='"+employe_id+"'");
					break;
				case 2 :
					System.out.print("| Entrer le nouveau password : ");
					String employe_password = sc.nextLine();
					stmt.executeUpdate("UPDATE employe SET password='"+employe_password+"' WHERE ID='"+employe_id+"'");
					break;
				case 3 :
					System.out.print("| Entrer le nouveau nom : ");
					String employe_nom = sc.nextLine();
					stmt.executeUpdate("UPDATE employe SET nom='"+employe_nom+"' WHERE ID='"+employe_id+"'");
					break;
				case 4 :
					System.out.print("| Entrer le nouveau prenom : ");
					String employe_prenom = sc.nextLine();
					stmt.executeUpdate("UPDATE employe SET prenom='"+employe_prenom+"' WHERE ID='"+employe_id+"'");
					break;
				case 5 :
					System.out.print("| Entrer le nouveau role : ");
					String employe_role = sc.nextLine();
					stmt.executeUpdate("UPDATE employe SET role='"+employe_role+"' WHERE ID='"+employe_id+"'");
					break;
				case 6 :
					System.out.print("| Entrer le nouveau salaire : ");
					double employe_salaire = sc.nextDouble();
					stmt.executeUpdate("UPDATE employe SET salaire='"+employe_salaire+"' WHERE ID='"+employe_id+"'");
					break;
				default:
					System.out.print("| champ n'existe pas!!!");
					break;
			}
			System.out.print("| Voulez vous modifier un autre employee ? ( 'o' pour oui , 'n'importe caractere' pour non ) : ");
			reponse = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		}
	}
	public void supprimerEmploye() throws SQLException {
		System.out.print("| Choisir l'id de l'employee : ");
		int employe_id = sc.nextInt();
		sc.nextLine();
		stmt.executeUpdate("DELETE FROM employe WHERE ID='"+employe_id+"'");

	}
	public void afficherEmploye() throws SQLException {
		ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe");
		System.out.print("| La liste des employes disponibles : \n");
		while(resultat_employe.next()) {
			Employe employe = new Employe(resultat_employe.getString("username"),resultat_employe.getString("password"),resultat_employe.getString("nom"),resultat_employe.getString("prenom"),resultat_employe.getString("role"),resultat_employe.getString("departement"),resultat_employe.getDouble("salaire"));
			System.out.print(employe+resultat_employe.getString("emploi"));
			System.out.print("\n");
		}
	}
//////////////////////////////////////////////////////////////////// Avion
	public void ajouterAvion() throws SQLException {
		char reponse='o';
		while(reponse=='o') {
			System.out.print("| Entrer modele : ");
			String avion_modele = sc.nextLine();
			System.out.print("| Entrer Capacite Maximale : ");
			double avion_capaciteMax = sc.nextDouble();
			stmt.executeUpdate("INSERT INTO avion(modele, capacite_max) VALUES ('"+avion_modele+"','"+ avion_capaciteMax + "')");
			System.out.print("| Vous avez bien ajoutez l'avion : " + avion_modele +" de capacite max : "+ avion_capaciteMax);
			System.out.print("| Voulez vous ajoutez une nouvelle avion (o pour oui / n pour non ) : ");
			reponse = sc.next().charAt(0);

			sc.nextLine();
		}
	}
	public void modifierAvion() throws SQLException {
		char reponse='o';
		while(reponse=='o'){
			System.out.print("| Choisir l'id de l'avion : ");
			int avion_id = sc.nextInt();
			sc.nextLine();
			System.out.print("| Chosir le champ a modifier ( 1 : Modele , 2 : Capacite maximale ) : ");
			int reponse_champ = sc.nextInt();
			sc.nextLine();
			switch (reponse_champ) {
				case 1:
					System.out.print("| Entrer le nouveau modele : ");
					String avion_model = sc.nextLine();
					stmt.executeUpdate("UPDATE avion SET modele='"+avion_model+"' WHERE ID='"+avion_id+"'");
					break;
				case 2 :

					System.out.print("| Entrer le nouveau capacite maximal : ");
					double avion_capaciteMax = sc.nextDouble();
					stmt.executeUpdate("UPDATE avion SET modele='"+avion_capaciteMax+"' WHERE ID='"+avion_id+"'");
					break;
				default:
					System.out.print("| champ n'existe pas!!!");
					break;
			}
			System.out.print("| Voulez vous modifier un autre avion ? ( 'o' pour oui , 'n'importe caractere' pour non ) : ");
			reponse = sc.next().charAt(0);
			sc.nextLine();
		}
	}
	public void supprimerAvion() throws SQLException {
		System.out.print("| Choisir l'id de l'avion : ");
		int avion_id = sc.nextInt();
		sc.nextLine();

		stmt.executeUpdate("DELETE FROM avion WHERE ID='"+avion_id+"'");
	}
	public void afficherAvion() throws SQLException {
		ResultSet resultat_avion = stmt.executeQuery("SELECT * FROM avion");
		System.out.print("| La liste des avions disponibles : ");
		while(resultat_avion.next()) {
			Avion avion = new Avion(resultat_avion.getString("modele"),resultat_avion.getInt("capacite_max"));
			System.out.print(avion);
		}
	}
//////////////////////////////////////////////////////////////////// Vols
	public void ajouterVol(){
		char reponse='o';
		while(reponse=='o') {

			System.out.print("| Entrer destination : ");
			String vol_destination = sc.nextLine();
			System.out.print("| Entrer origine : ");
			String vol_origine = sc.nextLine();

			System.out.print("| Entrer depart : ");
			String vol_depart = sc.nextLine();

			System.out.print("| Entrer arrive : ");
			String vol_arrive = sc.nextLine();
			System.out.println("| Choisir un employe Flight Stuff.");
			System.out.print("| Choisir l'id de l'employee : ");
			int pilote_id = sc.nextInt();

			System.out.print("| Choisir l'id de l'avion : ");
			int avion_id = sc.nextInt();
			
            System.out.print("| Entrer le prix : ");
            double prix = sc.nextDouble();
			try {
				stmt.executeUpdate("INSERT INTO vol (destination, origine, id_pilote, id_avion, depart, arrive, prix) VALUES ('" + vol_destination + "','" + vol_origine + "','" + pilote_id   + "','" +avion_id  + "','" + vol_depart + "','" + vol_arrive +"','"+prix+"')");				
				System.out.println("| Vous avez bien ajoutez le vol de : " + vol_origine + " vers " + vol_destination + " a l'heure " + vol_depart + " arriver en " + vol_arrive);
			} catch (SQLException e) {
			}
			try {
				affecterEmploiDuTempsDepart1(pilote_id,vol_depart,vol_arrive);
			} catch (SQLException e) {	
				System.out.println("| Vous avez affecter un employe d'un departement pas correcte, choisir un employe Flight Stuff !!");
			}
			System.out.print("| Voulez vous ajoutez un nouveau vol (o pour oui / n pour non ) : ");
			reponse = sc.next().charAt(0);

			sc.nextLine();
		
		}
	}
	public void modifierVol() throws SQLException{
		char reponse='o';
		while(reponse=='o'){
			System.out.print("| Choisir l'id du vol :  ");
			int vol_id = sc.nextInt();
			sc.nextLine();
			System.out.print("| Chosir le champ a modifier ( 1 : Destination , 2 : origine , 3 : pilote , 4 : avion , 5 : depart , 6 : arrive ) : ");
			int reponse_champ = sc.nextInt();
			sc.nextLine();
			switch (reponse_champ) {
				case 1:
					System.out.print("| Entrer le nouveau destination : ");
					String vol_destination = sc.nextLine();
					stmt.executeUpdate("UPDATE vol SET destination='"+vol_destination+"' WHERE ID='"+vol_id+"'");

					break;
				case 2 :
					System.out.print("| Entrer le nouveau origine: ");
					String vol_origine = sc.nextLine();
					stmt.executeUpdate("UPDATE vol SET origine='"+vol_origine+"' WHERE ID='"+vol_id+"'");
					break;
				case 3 :
					System.out.print("| Entrer le nouveau id de pilote qui vous voulez modifier : ");
					int pilote_id = sc.nextInt();
					sc.nextLine();
					stmt.executeUpdate("UPDATE vol SET id_pilote='"+pilote_id+"' WHERE ID='"+vol_id+"'");

					break;
				case 4 :
					System.out.print("| Entrer le nouveau id d'avion qui vous voulez modifier : ");
					int avion_id = sc.nextInt();
					sc.nextLine();
					stmt.executeUpdate("UPDATE vol SET id_avion='"+avion_id+"' WHERE ID='"+vol_id+"'");

					break;
				case 5 :
					System.out.print("| Entrer le nouveau depart : ");
					String vol_depart = sc.nextLine();
					stmt.executeUpdate("UPDATE vol SET depart='"+vol_depart+"' WHERE ID='"+vol_id+"'");
					break;
				case 6 :
					System.out.print("| Entrer le nouveau arrive: ");
					String vol_arrive= sc.nextLine();
					stmt.executeUpdate("UPDATE vol SET arrive='"+vol_arrive+"' WHERE ID='"+vol_id+"'");
					break;
				default:
					System.out.print("| champ n'existe pas!!!");
					break;
			}
			System.out.print("| Voulez vous modifier un autre vol ? ( 'o' pour oui , 'n'importe caractere' pour non ) : ");
			reponse = sc.next().charAt(0);

			sc.nextLine();
		}
	}
	public void supprimerVol() throws SQLException{
		System.out.print("| Choisir l'id du vol :  ");
		int vol_id = sc.nextInt();
		sc.nextLine();
		stmt.executeUpdate("DELETE FROM vol WHERE ID='"+vol_id+"'");

	}
	public void afficherVol() throws SQLException {
		ResultSet resultat_vol = stmt.executeQuery("SELECT * FROM vol");
		System.out.print("| La liste des vols disponibles : ");
		while(resultat_vol.next()) {
			Vol vol = new Vol(resultat_vol.getString("destination"),resultat_vol.getString("origine"),resultat_vol.getInt("id_pilote"),resultat_vol.getInt("id_avion"),resultat_vol.getString("depart"),resultat_vol.getString("arrive"),resultat_vol.getDouble("prix"));
			System.out.print(vol);
		}
	}
//////////////////////////////////////////////////////////////////// Les emplois de temps des employes selon le departement
	public void affecterEmploiDuTempsDepart1(int id_pilote,String depart,String arrive) throws SQLException {
		String emploiJour = " ";
		ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe WHERE ID='"+id_pilote+"'");
		while(resultat_employe.next()) {
			emploiJour = resultat_employe.getString("emploi");
		}
		ArrayList<Integer> ids = idsEmployeFlight();
		for(int id : ids) {
			
				if (id_pilote== id) {
					emploiJour = emploiJour +" | "+ depart + " - " + arrive;
				}
			}
			stmt.executeUpdate("UPDATE employe SET emploi='"+emploiJour+"' WHERE ID='"+id_pilote+"'");
			}
		
	
	public ArrayList<Integer> idsEmployeFlight() throws SQLException {
		ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe");
		ArrayList<Integer> ids = new ArrayList<>();
		while(resultat_employe.next()) {
			if(resultat_employe.getString("departement").equals("Flight Stuff")) {
				ids.add(resultat_employe.getInt("id"));
			}
		}
		return ids;
	}
	
	public void affecterEmploiDuTempsDepart2() throws SQLException {
		Random random = new Random();
		ArrayList<Integer> ids = idsEmployeGround();
		for(int id : ids) {
			if (isEmploiEmpty(id)==true) {
				String emploiJour = " ";
				for (String jour : jours) {
					int heureDebut = random.nextInt(24);
					int heureFin = heureDebut + 8;
					if (heureFin > 24) {
						heureFin = heureFin - 24;
					}
					emploiJour = emploiJour+"| "+jour + " " + heureDebut + "h - " + heureFin + "h";
				}
				stmt.executeUpdate("UPDATE employe SET emploi='"+emploiJour+"' WHERE ID='"+id+"'");
			}
		}
	}
	
	
	public ArrayList<Integer> idsEmployeGround() throws SQLException {
		ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe");
		ArrayList<Integer> ids = new ArrayList<>();
		while(resultat_employe.next()) {
			if(resultat_employe.getString("departement").equals("Ground Stuff")) {
				ids.add(resultat_employe.getInt("id"));
			}
		}
		return ids;
	}
	
	
	public boolean isEmploiEmpty(int id) throws SQLException {
		ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe WHERE ID='"+id+"'");
		boolean epmloiEmpty = false;
		
			while (resultat_employe.next()) {
						if (resultat_employe.getString("emploi") == null) {
							epmloiEmpty =  true;
						}
			}
			return epmloiEmpty;
	}
	
	
	
//////////////////////////////////////////////////////////////////// Generation d'un rapport sur l'aeroport
	public void genererRapportAeroport() throws SQLException{
		System.out.print("Rapport detailler du Aeroport : ");
		System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		afficherEmploye();
		System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		afficherAvion();
		System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		afficherVol();
		System.out.println("\n+----------------------------------------------------------------------------------------------------------------+");
		
	}
	
	
}