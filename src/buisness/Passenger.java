package buisness;

public class Passenger extends Person{
	private String num_passport;


/////////////////////////////////// Constructor
	public Passenger(String username, String password, String nom, String prenom,String num_passport) {
		super(username, password, nom, prenom);
		this.num_passport=num_passport;
	}
	public String getNum_passport() {
		return num_passport;
	}
	public void setNum_passport(String num_passport) {
		this.num_passport = num_passport;
	}
	
	@Override
	public String toString() {
		return "| Passenger : " + getUsername() + " | Nom : " + getNom() +" | Prenom : "+getPrenom()+ " | Numero du Passport : " + num_passport ;
	}
}
