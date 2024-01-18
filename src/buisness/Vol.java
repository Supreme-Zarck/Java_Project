package buisness;

public class Vol {
//////////////////////////////////////////Attributs
	private String destination;
	private String origine;
	private Employe pilote;
	private Avion  avion;
	private String depart;
	private String arrive;

	private int id;

	public Vol() {
		// TODO Auto-generated constructor stub
	}

	public Vol(int id,String destination, String origine, Employe pilote, Avion avion, String depart, String arrive) {
		this.id=id;
		this.destination = destination;
		this.origine = origine;
		this.depart = depart;
		this.arrive = arrive;
		this.pilote = pilote;
		this.avion = avion;
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

	public Employe getPilote() {
		return pilote;
	}

	public void setPilote(Employe pilote) {
		this.pilote = pilote;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
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

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vol{" +
				"destination='" + destination + "\n" +
				", origine='" + origine + "\n" +
				", pilote=" + pilote +"\n"+
				", avion=" + avion +"\n"+
				", depart='" + depart + "\n" +
				", arrive='" + arrive + "\n" +
				'}';
	}
}
