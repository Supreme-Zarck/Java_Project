package buisness;

import java.util.ArrayList;

public class Admin extends Person{
////////////////////////////////////////// Attributs
	private ArrayList<Employe> listeEmploye = new ArrayList<>();
	private ArrayList<Avion> listeAvion = new ArrayList<Avion>();
	
////////////////////////////////////////// Constructor 
	public Admin(String username, String password, String nom, String prenom) {
		super(username,password,nom,prenom);
	}

////////////////////////////////////////// Methods 
	public void ajouterEmploye(String username, String password, String nom, String prenom, String role ,double Salaire) {
		Employe employe = new Employe(username, password, nom, prenom, role, Salaire);
		listeEmploye.add(employe);
		System.out.println("Vous avez bien ajoutez " + employe); 
	}
	
	public void ajouterVol() {
		
	}


//////////////////////////////////////////toString
	@Override
	public String toString() {
		return "Admin [listeEmploye=" + listeEmploye + "]";
	}
	
}
