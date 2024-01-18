package buisness;

import java.util.ArrayList;
import java.util.Scanner;

public class Employe extends Person{
	//////////////////////////////////////////Attributs
	private String role;
	private double salaire;
	private ArrayList<String> emploi = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

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

	public void consulterInformations(){
		System.out.println("**** Vos Informations ****");
		String message="Employe{" + super.toString() +
				"role='" + role + "\n" +
				", salaire=" + salaire +"\n"+
				", emploi=" + emploi +"\n"+
				"} ";
		System.out.println(message);
		System.out.println("Voulez vous changer les informations ? ");
		String reponse = sc.nextLine();
		if(reponse=="o"){
			System.out.println("Entrer le nouveau username : ");
			String username = sc.nextLine();
			setUsername(username);

			System.out.println("Entrer le nouveau password : ");
			String password = sc.nextLine();
			setPassword(password);

		}
	}
	public void consulterAvionAffecte(){
		// base de donnee
	}

	////////////////////////////////////////// toString


	@Override
	public String toString() {
		return "Employe{" + super.toString() +
				"role='" + role + "\n" +
				", salaire=" + salaire +"\n"+
				", emploi=" + emploi +"\n"+
				"} ";
	}
}
