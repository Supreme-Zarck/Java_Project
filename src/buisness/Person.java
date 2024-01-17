package buisness;

public class Person {
	private int id;
	private String username;
	private String password;
	private String nom;
	private String prenom;

////////////////////////////////////////// Constructor 
	public Person(int id,String username, String password, String nom, String prenom) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

////////////////////////////////////////// Setters & getters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}

	//////////////////////////////////////////toString

}
