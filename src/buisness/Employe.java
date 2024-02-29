package buisness;

import java.util.ArrayList;
import java.util.Scanner;

public class Employe extends Person{
	//////////////////////////////////////////Attributs
	private String role;
	private double salaire;
	private String departement;
	private ArrayList<String> emploi = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	////////////////////////////////////////// Constructor
	public Employe(String username, String password, String nom, String prenom, String role, String departement,double salaire) {
		super(username,password,nom,prenom);
		this.role = role;
		this.departement = departement;
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

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}
	////////////////////////////////////////// toString
	@Override
	public String toString() {
		return "\n| => Employe Num : "+super.toString()+" | Role : "+role+" | Departement : "+departement+" | Salaire : "+salaire+"\n| Emploi De Temps : ";
	}
}
