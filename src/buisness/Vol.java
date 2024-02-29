package buisness;

public class Vol {
//////////////////////////////////////////Attributs
	private String destination;
	private String origine;
	private int id_pilote;
	private int id_avion;
	private String depart;
	private String arrive;
	private double prix;
	private static int tmp=1;

	private int id;
	public Vol() {
		// TODO Auto-generated constructor stub
	}

	public Vol(String destination, String origine,int id_pilote,int id_avion, String depart, String arrive, double prix) {
		this.id=tmp++;
		this.destination = destination;
		this.origine = origine;
		this.id_pilote = id_pilote;
		this.id_avion = id_avion;
		this.depart = depart;
		this.arrive = arrive;
		this.prix=prix;
	}

	public Vol(String destination, String origine, String depart, String arrive, double prix) {
		this.id=tmp++;
		this.destination = destination;
		this.origine = origine;
		this.depart = depart;
		this.arrive = arrive;
		this.prix=prix;
	}
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public int getId_pilote() {
		return id_pilote;
	}

	public void setId_pilote(int id_pilote) {
		this.id_pilote = id_pilote;
	}

	public int getId_avion() {
		return id_avion;
	}

	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public int getId() {
		return id;
	}


	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return  "\n| Vol Numero : "+id + " | Destination : " + destination +" | Origine : " + origine  + " | Pilote : " + id_pilote + " | Avion :  " + id_avion + " | Depart : " + depart  + " | Arrive : " + arrive + " | Prix : " + prix  ;
	}
}
