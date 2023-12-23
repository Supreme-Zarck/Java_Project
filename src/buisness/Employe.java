package buisness;

public class Employe extends Person{
//////////////////////////////////////////Attributs
	private String role;
	private double salaire;
	
////////////////////////////////////////// Constructor 
	public Employe(String username, String password, String nom, String prenom, String role, double salaire) {
		super(username,password,nom,prenom);
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

	
////////////////////////////////////////// toString
	@Override
	public String toString() {
		return "L'Employe :\n"+ super.toString() + "\n role : " + role + "\n salaire : " + salaire;
	}

}
