package buisness;

import java.util.ArrayList;

public class Employe extends Person{
//////////////////////////////////////////Attributs
	private String role;
	private double salaire;
	private ArrayList<String> emploi = new ArrayList<>();
	
////////////////////////////////////////// Constructor 
	public Employe(int id,String username, String password, String nom, String prenom, String role, double salaire) {
		super(id,username,password,nom,prenom);
		this.role = role;
		this.salaire = salaire;
	}

//////////////////////////////////////////Setters & getters
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	
	public ArrayList<String> getEmploi() {
		return emploi;
	}

	public void setEmploi(ArrayList<String> emploi) {
		this.emploi = emploi;
	}

	@Override
	public String toString() {
		return "Employe ["+super.toString()+"role=" + role + ", salaire=" + salaire + ", emploi=" + emploi + "]";
	}

	////////////////////////////////////////// toString

}
