package DAO;

import buisness.Employe;
import buisness.Vol;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeDAO {
	MaConnexion connexion;
	Statement stmt;
	Scanner sc = new Scanner(System.in);
	public EmployeDAO(MaConnexion connexion){
		this.connexion = connexion;
		stmt = connexion.getStmt();
	}
	public void consulterInformations(int id) throws SQLException {
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
	    System.out.println("| Vos Informations ");
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
	    ResultSet resultat_employe = stmt.executeQuery("SELECT * FROM employe WHERE ID='" + id + "'");
	    System.out.println("| La liste des employes disponibles  ");
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
	    if (resultat_employe.next()) {
	        Employe employe = new Employe(resultat_employe.getString("username"),
	                                      resultat_employe.getString("password"),
	                                      resultat_employe.getString("nom"),
	                                      resultat_employe.getString("prenom"),
	                                      resultat_employe.getString("role"),
	                                      resultat_employe.getString("departement"),
	                                      resultat_employe.getDouble("salaire"));
	        System.out.println(employe + resultat_employe.getString("emploi"));
	        System.out.print("| Voulez-vous changer les informations ? (o pour oui / n pour non ) :");
	        String reponse = sc.nextLine();
	        if ("o".equals(reponse)) {
	            System.out.print("| Entrer le nouveau username : ");
	            String username = sc.nextLine();
	            stmt.executeUpdate("UPDATE employe SET username='" + username + "' WHERE ID='" + id + "'");

	            System.out.print("| Entrer le nouveau password : ");
	            String password = sc.nextLine();
	            stmt.executeUpdate("UPDATE employe SET password='" + password + "' WHERE ID='" + id + "'");
	        }
	    }
	}
	public void consulterAvionAffecte(int id_pilote) throws SQLException {
	    // base de donnee
	    ResultSet resultat_vol = stmt.executeQuery("SELECT * FROM vol WHERE ID='" + id_pilote + "'");
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
	    System.out.println("| La liste de vos Avions  ");
		System.out.println("+----------------------------------------------------------------------------------------------------------------+");
	    while (resultat_vol.next()) {
	        Vol vol = new Vol(resultat_vol.getString("destination"),
	                          resultat_vol.getString("origine"),
	                          resultat_vol.getInt("id_pilote"),
	                          resultat_vol.getInt("id_avion"),
	                          resultat_vol.getString("depart"),
	                          resultat_vol.getString("arrive"),
	        				  resultat_vol.getDouble("prix"));
	        System.out.println(vol);
	    }
	}
}